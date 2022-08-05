package com.dearme.demo.domain.user.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserResponseDto {
    private String accessToken;
    private String refreshToken;
}
