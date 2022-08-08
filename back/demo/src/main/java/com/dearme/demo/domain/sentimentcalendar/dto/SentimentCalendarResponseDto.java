package com.dearme.demo.domain.sentimentcalendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SentimentCalendarResponseDto {
    private Integer year;
    private Integer month;
    private Integer day;
    private Long textdiaryid;
    private String textdiarysentiment;
    private Long textdiarypercentage;
    private Long videodiaryid;
    private String videodiarysentiment;
    private Long videodiarypercentage;
}
