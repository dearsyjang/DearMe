package com.dearme.demo.domain.counselingdocument.dto;

import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PostCounselingDocumentRequestDto {
    @NotBlank(message = "id는 비워둘 수 없습니다.")
    private Long id;

    @NotBlank(message = "year는 비워둘 수 없습니다.")
    private Integer year;
    @NotBlank(message = "month는 비워둘 수 없습니다.")
    private Integer month;
    @NotBlank(message = "day는 비워둘 수 없습니다.")
    private Integer day;
    @NotBlank(message = "hours는 비워둘 수 없습니다.")
    private Integer hours;
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;
    private Boolean isOpen;

    public CounselingDocument toEntity(){
        return CounselingDocument.builder()
                .year(this.year)
                .month(this.month)
                .day(this.day)
                .hours(this.hours)
                .contents(this.contents)
                .isOpen(this.isOpen)
                .build();
    }
}
