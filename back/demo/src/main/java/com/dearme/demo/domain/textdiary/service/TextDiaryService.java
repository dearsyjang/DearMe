package com.dearme.demo.domain.textdiary.service;

import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.dto.PostTextDiaryResponseDto;

public interface TextDiaryService {
    PostTextDiaryResponseDto postTextDiary(String id, PostTextDiaryRequestDto dto);
}
