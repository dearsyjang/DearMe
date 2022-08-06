package com.dearme.demo.domain.textdiary.dto;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PostTextDiaryRequestDto {
    private String title;
    private String contents;

    public TextDiary toEntity(){
        LocalDate now = LocalDate.now();
        return TextDiary.builder()
                .title(this.title)
                .contents(this.contents)
                .year(now.getYear())
                .month(now.getMonthValue())
                .day(now.getDayOfMonth())
                .build();
    }

}
