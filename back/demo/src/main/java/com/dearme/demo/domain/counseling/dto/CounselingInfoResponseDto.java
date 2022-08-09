package com.dearme.demo.domain.counseling.dto;

import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.entity.Status;
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
    private Integer hours;
    private Long counselingDocumentId;
    private Long groupId;
    private Status status;

    public static CounselingInfoResponseDto of(Counseling entity){
        if(entity.getCounselor() == null)
            return CounselingInfoResponseDto.builder()
                    .id(entity.getId())
                    .userId(entity.getUser().getUserId())
                    .groupId(entity.getGroup().getId())
                    .year(entity.getYear())
                    .month(entity.getMonth())
                    .day(entity.getDay())
                    .hours(entity.getHours())
                    .status(entity.getStatus())
                    .build();

        return CounselingInfoResponseDto.builder()
                .id(entity.getId())
                .userId(entity.getUser().getUserId())
                .counselorId(entity.getCounselor().getUserId())
                .year(entity.getYear())
                .month(entity.getMonth())
                .day(entity.getDay())
                .hours(entity.getHours())
                .counselingDocumentId(entity.getCounselingDocument().getId())
                .status(entity.getStatus())
                .build();
    }
}
