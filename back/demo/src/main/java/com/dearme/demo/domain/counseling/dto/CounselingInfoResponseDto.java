package com.dearme.demo.domain.counseling.dto;

import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.entity.Type;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CounselingInfoResponseDto {
    private Long id;
    private Long userId;
    private Long counselorId;
    private Integer year;
    private Integer month;
    private Integer day;
    private Long counselingDocumentId;
    private Long groupId;
    private Type type;

    public static CounselingInfoResponseDto of(Counseling entity){
        if(entity.getCounselor() == null)
            return CounselingInfoResponseDto.builder()
                    .id(entity.getId())
                    .userId(entity.getUser().getUserId())
                    .groupId(entity.getGroup().getId())
                    .year(entity.getYear())
                    .month(entity.getMonth())
                    .day(entity.getDay())
                    .type(entity.getType())
                    .build();

        return CounselingInfoResponseDto.builder()
                .id(entity.getId())
                .userId(entity.getUser().getUserId())
                .counselorId(entity.getCounselor().getUserId())
                .year(entity.getYear())
                .month(entity.getMonth())
                .day(entity.getDay())
                .counselingDocumentId(entity.getCounselingDocument().getId())
                .type(entity.getType())
                .build();
    }
}
