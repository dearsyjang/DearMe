package com.dearme.demo.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {
    private String accessToken;
    private String refreshToken;
}
