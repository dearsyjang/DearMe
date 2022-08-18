package com.dearme.demo.domain.counseling.dto;

import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.entity.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CounselorGroupCounselingsResponseDto {
    private Long id;
    private Long userId;
    private Long counselorId;
    private String counselorNickName;
    private Long counselingDocumentId;
    private Long groupId;
    private Status status;
    private String token;

    public static CounselorGroupCounselingsResponseDto of(Counseling entity){
        return CounselorGroupCounselingsResponseDto.builder()
                .id(entity.getId())
                .userId(entity.getUser().getUserId())
                .counselorId(entity.getCounselor().getUserId())
                .counselorNickName(entity.getCounselor().getNickName())
                .counselingDocumentId(entity.getCounselingDocument().getId())
                .groupId(entity.getGroup().getId())
                .status(entity.getStatus())
                .token(entity.getToken())
                .build();
    }
}
