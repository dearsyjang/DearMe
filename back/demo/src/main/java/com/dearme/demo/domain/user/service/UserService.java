package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.counselorprofile.*;
import com.dearme.demo.domain.user.dto.etc.PointsUpdateResponseDto;
import com.dearme.demo.domain.user.dto.etc.ReviewViewResponseDto;
import com.dearme.demo.domain.user.dto.etc.UserGroupListResponseDto;
import com.dearme.demo.domain.user.dto.user.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    SignUpResponseDto signUpUser(SignUpRequestDto dto) throws IOException;
    LoginResponseDto login(LoginRequestDto dto);
    UpdateUserResponseDto update(String id, UpdateUserRequestDto dto);
    GetAccessTokenResponseDto getAccessToken(String refreshToken);
    UpdateCertificateResponseDto updateCertificate(String id, UpdateCertificateRequestDto dto);
    UpdateCareerResponseDto updateCareer(String id, UpdateCareerRequestDto dto);
    UpdateCategoryResponseDto updateCategory(String id, UpdateCategoryRequestDto dto);
    void checkId(String id);
    void checkNickname(String nickname);
    void delete(String id);

    PointsUpdateResponseDto pointsUpdate(String id, String price);

    UserInfoResponseDto getUserInfo(String id);

    UserInfoResponseDto getUserInfo(String counselorId, Long userId);

    List<ReviewViewResponseDto> getReviews(String id);

    UserGroupListResponseDto getGroups(String id);

    void deleteCareer(String id, Long careerId);

    void deleteCounselorCertificate(String id, Long certificateId);

    void deleteCounselorCategory(String id, Long categoryId);

    void addCounselorCareer(String id, AddCareerRequestDto dto);

    void addCounselorCertificate(String id, AddCertificateDto dto);

    void addCounselorCategory(String id, AddCategoryRequestDto dto);

    void withdrawalUserGroup(String id, Long groupId);

//    byte[] getUserProfileImage(String id) throws IOException;
    byte[] getUserProfileImage(Long userId) throws IOException;

    void updateUserProfileImage(String id, MultipartFile picture) throws IOException;
}
