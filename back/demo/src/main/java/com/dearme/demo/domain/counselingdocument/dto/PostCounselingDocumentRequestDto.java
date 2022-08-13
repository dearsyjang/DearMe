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
    @NotBlank(message = "date는 비워둘 수 없습니다.")
    private LocalDateTime date;
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;
    @NotBlank(message = "isOpen은 비워둘 수 없습니다.")
    private Boolean isOpen;

    public CounselingDocument toEntity(){
        return CounselingDocument.builder()
                .year(this.date.getYear())
                .month(this.date.getMonthValue())
                .day(this.date.getDayOfMonth())
                .hours(this.date.getHour())
                .contents(this.contents)
                .isOpen(this.isOpen)
                .build();
    }
}
