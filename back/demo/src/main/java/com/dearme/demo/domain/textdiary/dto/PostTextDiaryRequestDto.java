package com.dearme.demo.domain.textdiary.dto;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Data
public class PostTextDiaryRequestDto {
    @NotBlank(message = "title은 비워둘 수 없습니다.")
    private String title;
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
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
