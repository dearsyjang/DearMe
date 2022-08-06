package com.dearme.demo.domain.counselingdocument.dto;

import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostCounselingDocumentRequestDto {
    private Long counselorId;
    private LocalDate date;
    private String contents;
    private Boolean isOpen;

    public CounselingDocument toEntity(){
        return CounselingDocument.builder()
                .year(this.date.getYear())
                .month(this.date.getMonthValue())
                .day(this.date.getDayOfMonth())
                .contents(this.contents)
                .isOpen(this.isOpen)
                .build();
    }
}
