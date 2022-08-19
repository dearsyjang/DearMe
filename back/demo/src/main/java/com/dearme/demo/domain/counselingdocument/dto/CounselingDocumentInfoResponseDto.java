package com.dearme.demo.domain.counselingdocument.dto;

import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CounselingDocumentInfoResponseDto {
    private Long counselorId;
    private Long userId;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hours;
    private String contents;
    private Boolean isOpen;
    private Long counselingId;

    public static CounselingDocumentInfoResponseDto of(CounselingDocument entity){
        return CounselingDocumentInfoResponseDto.builder()
                .counselorId(entity.getCounselor().getUserId())
                .userId(entity.getUser().getUserId())
                .year(entity.getYear())
                .month(entity.getMonth())
                .day(entity.getDay())
                .hours(entity.getHours())
                .contents(entity.getContents())
                .isOpen(entity.getIsOpen())
                .counselingId(entity.getCounseling().getId())
                .build();
    }
}
