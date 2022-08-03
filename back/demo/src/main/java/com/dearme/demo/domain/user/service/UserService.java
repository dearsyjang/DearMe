package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.LoginRequestDto;
import com.dearme.demo.domain.user.dto.LoginResponseDto;
import com.dearme.demo.domain.user.dto.SignUpRequestDto;
import com.dearme.demo.domain.user.dto.SignUpResponseDto;

import java.io.IOException;

public interface UserService {
    SignUpResponseDto signUpUser(SignUpRequestDto dto);
    LoginResponseDto login(LoginRequestDto dto);
}
