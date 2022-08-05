package com.dearme.demo.domain.textdiary.dto;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TextDiaryDetailsResponseDto {
    private Long id;
    private String title;
    private String contents;

    public static TextDiaryDetailsResponseDto of(TextDiary entity){
        return TextDiaryDetailsResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .build();
    }
}
