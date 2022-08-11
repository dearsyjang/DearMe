package com.dearme.demo.domain.counselingroom.dto;

import com.dearme.demo.domain.counseling.entity.Counseling;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetSessionTokenResponseDto {

    private String sessionName;

    private String token;

    public static GetSessionTokenResponseDto of(Counseling entity){
        return GetSessionTokenResponseDto.builder()
                .sessionName(entity.getCounselingRoom().getSessionName())
                .token(entity.getToken())
                .build();
    }
}
