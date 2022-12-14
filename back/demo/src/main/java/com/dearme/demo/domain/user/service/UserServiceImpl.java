package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import com.dearme.demo.domain.counselingdocument.exception.NoExistDocumentException;
import com.dearme.demo.domain.counselingdocument.repository.CounselingDocumentRepository;
import com.dearme.demo.domain.favorite.repository.FavoriteRepository;
import com.dearme.demo.domain.recordingroom.exception.RecordingDeleteException;
import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.review.repository.ReviewRepository;
import com.dearme.demo.domain.user.dto.counselorprofile.*;
import com.dearme.demo.domain.user.dto.etc.PointsUpdateResponseDto;
import com.dearme.demo.domain.user.dto.etc.ReviewViewResponseDto;
import com.dearme.demo.domain.user.dto.etc.UserGroupListResponseDto;
import com.dearme.demo.domain.user.dto.etc.UserGroupResponseDto;
import com.dearme.demo.domain.user.dto.user.*;
import com.dearme.demo.domain.user.entity.*;
import com.dearme.demo.domain.user.exception.*;
import com.dearme.demo.domain.user.repository.*;
import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import com.dearme.demo.global.util.jwt.JwtProvider;
import io.openvidu.java.client.OpenVidu;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final JwtProvider jwtProvider;

    private final UserRepository userRepository;

    private final CounselorProfileRepository counselorProfileRepository;

    private final CareerRepository careerRepository;

    private final CategoryRepository categoryRepository;

    private final CertificateRepository certificateRepository;

    private final GroupUserRepository groupUserRepository;

    private final ReviewRepository reviewRepository;

    private final FavoriteRepository favoriteRepository;

    private final CounselingDocumentRepository counselingDocumentRepository;

    @Value("${path.image:/image/}")
    private String IMAGE_PATH;

    private final OpenVidu openvidu;

    @Override
    @Transactional
    public SignUpResponseDto signUpUser(SignUpRequestDto dto) throws IOException {
        Picture picture = null;
        User user = dto.toUserEntity();
        if(user.getType().equals(Type.COUNSELOR)){
            if(dto.getPicture() == null) throw new CounselorNotExistPictureException();
            CounselorProfile counselorProfile = dto.toCounselorProfileEntity();
            List<Career> careers = dto.getCounselorProfile().toCareersEntity();
            for(Career career : careers){
                career.setCounselorProfile(counselorProfile);
            }
            List<Certificate> certificates = dto.getCounselorProfile().toCertificatesEntity();
            for(Certificate certificate : certificates){
                certificate.setCounselorProfile(counselorProfile);
            }
            List<Category> categories = dto.getCounselorProfile().toCategoriesEntity();
            for(Category category : categories){
                category.setCounselorProfile(counselorProfile);
            }
            user.setCounselorProfile(counselorProfile);
        }
        if(dto.getPicture() == null || dto.getPicture().isEmpty()) {
            if(dto.getType().equals(Type.COUNSELOR)){
                throw new CounselorNotExistPictureException();
            }else{
                picture = Picture.builder().fileName("basic").realFileName("basic.png").build();
            }
        }else {
            String fileName = UUID.randomUUID().toString();
            String contentType = dto.getPicture().getContentType();
            File file = null;
            if(contentType.contains("image/jpeg")){
                file = new File(IMAGE_PATH + fileName + ".jpg");
                picture = Picture.builder().fileName(fileName).realFileName(fileName + ".jpg").build();
            }else if(contentType.contains("image/png")){
                file = new File(IMAGE_PATH + fileName + ".png");
                picture = Picture.builder().fileName(fileName).realFileName(fileName + ".png").build();
            }else if(contentType.contains("image/gif")){
                file = new File(IMAGE_PATH + fileName + ".gif");
                picture = Picture.builder().fileName(fileName).realFileName(fileName + ".gif").build();
            }else{
                throw new ImageContentTypeException();
            }
            dto.getPicture().transferTo(file);
        }
        user.setPicture(picture);
        String accessToken = jwtProvider.getAccessToken(user.getId());
        String refreshToken = jwtProvider.getRefreshToken();
        user.updateRefreshToken(refreshToken);
        userRepository.save(user);

        return SignUpResponseDto.of(accessToken, refreshToken);
    }


    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        User user = userRepository.findUserByIdAndPw(dto.getId(), dto.getPw()).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        return new LoginResponseDto(jwtProvider.getAccessToken(user.getId()), jwtProvider.getRefreshToken());
    }

    @Override
    @Transactional
    public UpdateUserResponseDto update(String id, UpdateUserRequestDto dto) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getType().equals(Type.USER)){
            user.updateUser(dto.getPw(), dto.getNickName());
        }else{
            CounselorProfile targetCounselorProfile = counselorProfileRepository.findById(user.getUserId()).orElseThrow(() -> {
                throw new NoExistUserException();
            });
            targetCounselorProfile.updateCounselorProfile(dto.getCounselorProfile().getPrice(), dto.getCounselorProfile().getIntroduce());
            user.updateCounselor(dto.getPw(), dto.getNickName(), targetCounselorProfile);
        }
        String accessToken = jwtProvider.getAccessToken(user.getId());
        String refreshToken = jwtProvider.getRefreshToken();
        user.updateRefreshToken(refreshToken);
        userRepository.save(user);
        return new UpdateUserResponseDto(accessToken, refreshToken);
    }

    @Override
    public GetAccessTokenResponseDto getAccessToken(String refreshToken) {
        User user = userRepository.findUserByRefreshToken(refreshToken).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        return new GetAccessTokenResponseDto(jwtProvider.getAccessToken(user.getId()));
    }

    @Override
    @Transactional
    public UpdateCertificateResponseDto updateCertificate(String id, UpdateCertificateRequestDto dto) {
        Certificate certificate = certificateRepository.findCertificateByCounselorProfile_Counselor_IdAndId(id, dto.getId())
                .orElseThrow(() -> {
                    throw new NoExistCertificateException();
                });
        certificate.updateCertificate(dto.getContents());
        certificateRepository.save(certificate);
        return new UpdateCertificateResponseDto(certificate.getId(), certificate.getContents());
    }

    @Override
    @Transactional
    public UpdateCareerResponseDto updateCareer(String id, UpdateCareerRequestDto dto) {
        Career career = careerRepository.findCareerByCounselorProfile_Counselor_IdAndId(id, dto.getId())
                .orElseThrow(() -> {
                    throw new NoExistCareerException();
                });
        career.updateCareer(dto.getContents());
        careerRepository.save(career);
        return new UpdateCareerResponseDto(career.getId(), career.getContents());
    }

    @Override
    @Transactional
    public UpdateCategoryResponseDto updateCategory(String id, UpdateCategoryRequestDto dto) {
        Category category = categoryRepository.findCategoryByCounselorProfile_Counselor_IdAndId(id, dto.getId())
                .orElseThrow(() -> {
                    throw new NoExistCategoryException();
                });
        categoryRepository.save(category);
        return new UpdateCategoryResponseDto(category.getId(), category.getContents());
    }

    @Override
    public void checkId(String id) {
        if(userRepository.existsUserById(id)) throw new DuplicatedIdException(id);
    }

    @Override
    public void checkNickname(String nickname) {
        if(userRepository.existsUserByNickName(nickname)) throw new DuplicatedNickNameException(nickname);
    }

    @Override
    @Transactional
    public void delete(String id) {
        User target = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        String pictureName = target.getPicture().getRealFileName();
        if(!pictureName.equals("basic.png")) {
            File file = new File(IMAGE_PATH + pictureName);
            file.delete();
        }
        if(target.getType().equals(Type.COUNSELOR)){
            reviewRepository.deleteReviewByCounselor_UserId(target.getUserId());
            favoriteRepository.deleteFavoriteByCounselor_UserId(target.getUserId());
        }

        try {
            for (VideoDiary v : target.getVideoDiaries())
                openvidu.deleteRecording(v.getRealFileName());
        }catch (Exception e){
            throw new RecordingDeleteException();
        }
        userRepository.deleteUserById(id);
    }

    @Override
    @Transactional
    public PointsUpdateResponseDto pointsUpdate(String id, String price) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        Long points=Long.parseLong(price);

        user.updatePoints(points);
        return new PointsUpdateResponseDto(user.getPoints());
    }

    @Override
    public UserInfoResponseDto getUserInfo(String id) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getType().equals(Type.COUNSELOR)){
            return UserInfoResponseDto.ofCounselor(user);
        }
        return UserInfoResponseDto.ofUser(user);
    }

    @Override
    public UserInfoResponseDto getUserInfo(String counselorId, Long userId) {
        CounselingDocument latestCounselingDocument = counselingDocumentRepository.findTop1ByCounselor_IdAndUser_UserIdOrderByYearDescMonthDescHoursDesc(counselorId, userId).orElseThrow(() -> {
           throw new NoExistDocumentException();
        });
        if(!latestCounselingDocument.getIsOpen()){
            return getUserInfo(latestCounselingDocument.getUser().getId());
        }
        throw new NoPermissionUserInfoException();
    }

    @Override
    public List<ReviewViewResponseDto> getReviews(String id) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });

        List<Review> tempList=user.getReviews();
        List<ReviewViewResponseDto> reviewList = new ArrayList<>();
        for(Review r : tempList){
            User counselor = userRepository.findUserById(r.getCounselor().getId()).orElseThrow(() -> {
                throw new NoExistUserException();
            });
            reviewList.add(ReviewViewResponseDto.of(r, counselor));
        }
        return reviewList;
    }


    @Override
    public UserGroupListResponseDto getGroups(String id) {
        List<UserGroupResponseDto> userGroupResponseDtos = new ArrayList<>();
        List<GroupUser> groupUsers = groupUserRepository.findAllByUser_Id(id);
        for(GroupUser groupUser : groupUsers){
            userGroupResponseDtos.add(UserGroupResponseDto.of(groupUser.getGroup()));
        }
        return new UserGroupListResponseDto(userGroupResponseDtos);
    }

    @Override
    @Transactional
    public void deleteCareer(String id, Long careerId) {
        careerRepository.deleteCareerByCounselorProfile_Counselor_IdAndId(id, careerId);
    }

    @Override
    @Transactional
    public void deleteCounselorCertificate(String id, Long certificateId) {
        certificateRepository.deleteCertificateByCounselorProfile_Counselor_IdAndId(id, certificateId);
    }

    @Override
    @Transactional
    public void deleteCounselorCategory(String id, Long categoryId) {
        categoryRepository.deleteCategoryByCounselorProfile_Counselor_IdAndId(id, categoryId);
    }

    @Override
    public void addCounselorCareer(String id, AddCareerRequestDto dto) {
        CounselorProfile counselorProfile = counselorProfileRepository.findCounselorProfileByCounselor_Id(id);
        Career career = dto.toEntity();
        career.setCounselorProfile(counselorProfile);
        careerRepository.save(career);
    }

    @Override
    public void addCounselorCertificate(String id, AddCertificateDto dto) {
        CounselorProfile counselorProfile = counselorProfileRepository.findCounselorProfileByCounselor_Id(id);
        Certificate certificate = dto.toEntity();
        certificate.setCounselorProfile(counselorProfile);
        certificateRepository.save(certificate);
    }

    @Override
    public void addCounselorCategory(String id, AddCategoryRequestDto dto) {
        CounselorProfile counselorProfile = counselorProfileRepository.findCounselorProfileByCounselor_Id(id);
        Category category = dto.toEntity();
        category.setCounselorProfile(counselorProfile);
        categoryRepository.save(category);
    }

    @Override
    public void withdrawalUserGroup(String id, Long groupId) {
        groupUserRepository.deleteGroupUserByUser_IdAndGroup_Id(id, groupId);
    }

    @Override
    public byte[] getUserProfileImage(Long userId) throws IOException {
        User user = userRepository.findUserByUserId(userId).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        InputStream inputStream = new FileInputStream(IMAGE_PATH + user.getPicture().getRealFileName());
        return IOUtils.toByteArray(inputStream);
    }

    @Override
    public void updateUserProfileImage(String id, MultipartFile updatePicture) throws IOException {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        Picture picture = null;

        if(!user.getPicture().getRealFileName().equals("basic.png")) {
            File oldFile = new File(IMAGE_PATH + user.getPicture().getRealFileName());
            oldFile.delete();
        }

        if(updatePicture == null || updatePicture.isEmpty()) {
            if(user.getType().equals(Type.COUNSELOR)){
                throw new CounselorNotExistPictureException();
            }else{
                picture = Picture.builder().fileName("basic").realFileName("basic.png").build();
            }
        }else {
            String fileName = UUID.randomUUID().toString();
            String contentType = updatePicture.getContentType();
            File newFile = null;
            if(contentType.contains("image/jpeg")){
                newFile = new File(IMAGE_PATH + fileName + ".jpg");
                picture = Picture.builder().fileName(fileName).realFileName(fileName + ".jpg").build();
            }else if(contentType.contains("image/png")){
                newFile = new File(IMAGE_PATH + fileName + ".png");
                picture = Picture.builder().fileName(fileName).realFileName(fileName + ".png").build();
            }else if(contentType.contains("image/gif")){
                newFile = new File(IMAGE_PATH + fileName + ".gif");
                picture = Picture.builder().fileName(fileName).realFileName(fileName + ".gif").build();
            }else{
                throw new ImageContentTypeException();
            }
            updatePicture.transferTo(newFile);
        }
        user.updateImage(picture);
        userRepository.save(user);
    }
}
