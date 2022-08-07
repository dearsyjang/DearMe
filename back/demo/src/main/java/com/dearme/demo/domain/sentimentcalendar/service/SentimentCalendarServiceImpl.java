package com.dearme.demo.domain.sentimentcalendar.service;


import com.dearme.demo.domain.sentimentcalendar.dto.*;
import com.dearme.demo.domain.textdiary.dto.TextDiaryDetailsResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryListResponseDto;
import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.textdiary.repository.TextDiaryRepository;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.dearme.demo.domain.videodiary.dto.PostUpdateVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.dto.PostVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.dto.PostVideoDiaryResponseDto;
import com.dearme.demo.domain.videodiary.dto.VideoDiaryDetailsResponseDto;
import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import com.dearme.demo.domain.videodiary.repository.VideoDiaryRepository;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
