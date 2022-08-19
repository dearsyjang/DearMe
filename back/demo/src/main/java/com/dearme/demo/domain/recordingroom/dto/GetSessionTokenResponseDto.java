package com.dearme.demo.domain.recordingroom.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetSessionTokenResponseDto {
    private String token;

    public static GetSessionTokenResponseDto of(String token){
        return GetSessionTokenResponseDto.builder().token(token).build();
    }
}
