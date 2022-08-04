package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.*;

import java.io.IOException;

import java.io.IOException;

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
    Long pointsUpdate(String id, Long price);
}
