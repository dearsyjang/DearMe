package com.dearme.demo.domain.videodiary.service;

import com.dearme.demo.domain.textdiary.dto.TextDiaryDetailsResponseDto;
import com.dearme.demo.domain.videodiary.dto.PostUpdateVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.dto.PostVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.dto.PostVideoDiaryResponseDto;
import com.dearme.demo.domain.videodiary.dto.VideoDiaryDetailsResponseDto;

import java.io.IOException;

public interface VideoDiaryService {
    PostVideoDiaryResponseDto postVideoDiary(String id, PostVideoDiaryRequestDto dto) throws IOException;

    PostVideoDiaryResponseDto postUpdateVideoDiary(String id, Long videoDiaryId, PostUpdateVideoDiaryRequestDto dto);

    VideoDiaryDetailsResponseDto getDetails(String id, Long videoDiaryId);

    VideoDiaryListResponseDto getList(String id, Integer year, Integer month);
//
//    void delete(String id, Long textDiaryId);
//
//    VideoSaveResponseDto videoSave() throws IOException;
}
