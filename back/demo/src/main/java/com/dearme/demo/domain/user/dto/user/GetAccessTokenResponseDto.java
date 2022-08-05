package com.dearme.demo.domain.user.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAccessTokenResponseDto {
    private String accessToken;
}
