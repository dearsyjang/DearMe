package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.PointsUpdateResponseDto;
import com.dearme.demo.domain.user.dto.ReviewViewResponseDto;
import com.dearme.demo.domain.user.dto.UserGroupListResponseDto;
import com.dearme.demo.domain.user.dto.user.*;

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

    List<ReviewViewResponseDto> getReviews(String id);

    UserGroupListResponseDto getGroups(String id);

    void deleteCareer(String id, Long careerId);

    void deleteCounselorCertificate(String id, Long certificateId);
}
