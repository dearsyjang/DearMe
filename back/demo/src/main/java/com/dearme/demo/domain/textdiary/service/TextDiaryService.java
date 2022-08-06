package com.dearme.demo.domain.textdiary.service;

import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.dto.PostTextDiaryResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryDetailsResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryListResponseDto;

import com.dearme.demo.domain.textdiary.dto.TextDiaryListResponseDto;

import com.dearme.demo.domain.textdiary.dto.TextDiaryListResponseDto;

public interface TextDiaryService {
    PostTextDiaryResponseDto postTextDiary(String id, PostTextDiaryRequestDto dto);

    TextDiaryDetailsResponseDto getDetails(String id, Long textDiaryId);

    TextDiaryListResponseDto getList(String id, Integer year, Integer month);

    void delete(String id, Long textDiaryId);
}

