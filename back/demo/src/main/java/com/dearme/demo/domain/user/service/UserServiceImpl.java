package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.*;
import com.dearme.demo.domain.user.entity.*;
import com.dearme.demo.domain.user.exception.*;
import com.dearme.demo.domain.user.repository.*;
import com.dearme.demo.global.util.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
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
        if(dto.getPicture() != null){
            picture = Picture.builder().fileName(dto.getPicture().getOriginalFilename()).realFileName(UUID.randomUUID().toString()).build();
            File file = new File("C:\\Users\\multicampus\\Desktop\\project\\S07P12D206\\back\\demo\\src\\main\\resources\\static\\" + picture.getRealFileName() + ".jpeg");
            dto.getPicture().transferTo(file);
            user.setPicture(picture);
        }
        String accessToken = jwtProvider.getAccessToken(user.getId());
        String refreshToken = jwtProvider.getRefreshToken();
        user.updateRefreshToken(refreshToken);
        userRepository.save(user);

        return SignUpResponseDto
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
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
        userRepository.save(user);
        return new UpdateUserResponseDto(jwtProvider.getAccessToken(user.getId()), jwtProvider.getRefreshToken());
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
        CounselorProfile counselorProfile = counselorProfileRepository.findCounselorProfileByCounselor_Id(id);
        Certificate certificate = certificateRepository.findById(dto.getId()).get();
        if(counselorProfile.equals(certificate.getCounselorProfile()))
            certificate.updateCertificate(dto.getContents());
        certificateRepository.save(certificate);
        return new UpdateCertificateResponseDto(certificate.getId(), certificate.getContents());
    }

    @Override
    @Transactional
    public UpdateCareerResponseDto updateCareer(String id, UpdateCareerRequestDto dto) {
        CounselorProfile counselorProfile = counselorProfileRepository.findCounselorProfileByCounselor_Id(id);
        Career career = careerRepository.findById(dto.getId()).get();
        if(counselorProfile.equals(career.getCounselorProfile()))
            career.updateCareer(dto.getContents());
        careerRepository.save(career);
        return new UpdateCareerResponseDto(career.getId(), career.getContents());
    }

    @Override
    @Transactional
    public UpdateCategoryResponseDto updateCategory(String id, UpdateCategoryRequestDto dto) {
        CounselorProfile counselorProfile = counselorProfileRepository.findCounselorProfileByCounselor_Id(id);
        Category category = categoryRepository.findById(dto.getId()).get();
        if(counselorProfile.equals(category.getCounselorProfile()))
            category.updateCategory(dto.getContents());
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
}
