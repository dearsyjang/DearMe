package com.dearme.demo.domain.textdiary.dto;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import lombok.Data;

@Data
public class PostTextDiaryRequestDto {
    private String title;
    private String contents;

    public TextDiary toEntity(){
        return TextDiary.builder()
                .title(this.title)
                .contents(this.contents)
                .build();
    }
}
