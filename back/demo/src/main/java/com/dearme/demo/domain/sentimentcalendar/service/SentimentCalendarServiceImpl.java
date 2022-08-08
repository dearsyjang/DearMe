package com.dearme.demo.domain.sentimentcalendar.service;


import com.dearme.demo.domain.sentimentcalendar.dto.SentimentCalendarResponseDto;
import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.textdiary.repository.TextDiaryRepository;
import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import com.dearme.demo.domain.videodiary.repository.VideoDiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SentimentCalendarServiceImpl implements SentimentCalendarService {

    private final VideoDiaryRepository videoDiaryRepository;
    private final TextDiaryRepository textDiaryRepository;

    @Override
    public List<SentimentCalendarResponseDto> getSentiments(String id, Integer year, Integer month) {
        List<VideoDiary> videoDiaries = videoDiaryRepository.findAllByUser_IdAndYearAndMonth(id, year, month);
        List<TextDiary> textDiaries = textDiaryRepository.findAllByUser_IdAndYearAndMonth(id, year, month);
        List<SentimentCalendarResponseDto> sentimentCalendarResponseDtos = new ArrayList<>();
        for(int i=0;i<=31;i++)
            sentimentCalendarResponseDtos.add(new SentimentCalendarResponseDto(year, month, i, null, null, null, null, null, null));

        for(VideoDiary videoDiary : videoDiaries){
            sentimentCalendarResponseDtos.get(videoDiary.getDay()).setVideodiaryid(videoDiary.getId());
            sentimentCalendarResponseDtos.get(videoDiary.getDay()).setVideodiarysentiment(videoDiary.getSentiment());
            sentimentCalendarResponseDtos.get(videoDiary.getDay()).setVideodiarypercentage(videoDiary.getPercentage());
        }
        for(TextDiary textDiary : textDiaries){
            sentimentCalendarResponseDtos.get(textDiary.getDay()).setTextdiaryid(textDiary.getId());
            sentimentCalendarResponseDtos.get(textDiary.getDay()).setTextdiarysentiment(textDiary.getSentiment());
            sentimentCalendarResponseDtos.get(textDiary.getDay()).setTextdiarypercentage(textDiary.getPercentage());
        }
        return sentimentCalendarResponseDtos;
    }
}
