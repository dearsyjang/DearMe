package com.dearme.demo.domain.user.dto.user;

import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.user.dto.etc.ReviewViewResponseDto;
import com.dearme.demo.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpResponseDto {
    private String refreshToken;
    private String accessToken;

    public static SignUpResponseDto of(String accessToken, String refreshToken){
        return SignUpResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
