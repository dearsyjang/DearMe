package com.dearme.demo.domain.textdiary.service;

import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.dto.PostTextDiaryResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryDetailsResponseDto;

public interface TextDiaryService {
    PostTextDiaryResponseDto postTextDiary(String id, PostTextDiaryRequestDto dto);

    TextDiaryDetailsResponseDto getDetails(String id, Long textDiaryId);
}
