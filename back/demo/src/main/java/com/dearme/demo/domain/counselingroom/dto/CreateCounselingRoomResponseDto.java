package com.dearme.demo.domain.counselingroom.dto;

import com.dearme.demo.domain.counselingroom.entity.CounselingRoom;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCounselingRoomResponseDto {
    private String sessionName;
    private String counselorToken;

    public static CreateCounselingRoomResponseDto of(CounselingRoom entity){
        return CreateCounselingRoomResponseDto.builder()
                .sessionName(entity.getSessionName())
                .counselorToken(entity.getCounselorToken())
                .build();
    }
}
