package com.dearme.demo.domain.videodiary.service;

import com.dearme.demo.domain.videodiary.dto.VideoDiaryPostRequestDto;
import com.dearme.demo.domain.videodiary.dto.VideoDiaryPostResponseDto;

public interface VideoDiaryService {
    VideoDiaryPostResponseDto recording(String id, VideoDiaryPostRequestDto dto);
    String getToken(String id);
}
