package com.dearme.demo.domain.videodiary.service;

import com.dearme.demo.domain.videodiary.dto.*;

import java.io.IOException;

public interface VideoDiaryService {
    PostVideoDiaryResponseDto postVideoDiary(String id, PostVideoDiaryRequestDto dto) throws IOException;

    PostVideoDiaryResponseDto postUpdateVideoDiary(String id, Long videoDiaryId, PostUpdateVideoDiaryRequestDto dto);

    VideoDiaryDetailsResponseDto getDetails(String id, Long videoDiaryId);

    VideoDiaryListResponseDto getList(String id, Integer year, Integer month);

    void delete(String id, Long videoDiaryId);

    VideoDiaryListResponseDto getUserList(String id, Long userId, Integer year, Integer month);
}
