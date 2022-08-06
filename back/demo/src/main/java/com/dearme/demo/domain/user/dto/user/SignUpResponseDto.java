package com.dearme.demo.domain.user.dto.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpResponseDto {
    private String refreshToken;
    private String accessToken;
}
