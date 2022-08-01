package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.SignUpRequestDto;
import com.dearme.demo.domain.user.dto.SignUpResponseDto;

public interface UserService {
    SignUpResponseDto signUpUser(SignUpRequestDto dto);
}
