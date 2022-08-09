package com.dearme.demo.domain.sentimentcalendar.service;

import com.dearme.demo.domain.sentimentcalendar.dto.SentimentCalendarResponseDto;

import java.util.List;

public interface SentimentCalendarService {

    List<SentimentCalendarResponseDto> getSentiments(String id, Integer year, Integer month);

}
