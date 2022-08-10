package com.dearme.demo.domain.textdiary.dto;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class TextDiaryDetailsResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String sentiment;
    private Double percentage;
    private Double positive;
    private Double negative;
    private Double neutral;
    private Integer year;
    private Integer month;
    private Integer day;

    public static TextDiaryDetailsResponseDto of(TextDiary entity){
        return TextDiaryDetailsResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .sentiment(entity.getSentiment())
                .percentage(entity.getPercentage())
                .positive(entity.getPositive())
                .negative(entity.getNegative())
                .neutral(entity.getNeutral())
                .year(entity.getYear())
                .month(entity.getMonth())
                .day(entity.getDay())
                .build();
    }
}
