package com.dearme.demo.domain.videodiary.service;

import com.dearme.demo.domain.videodiary.dto.PostUpdateVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.dto.PostVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.dto.PostVideoDiaryResponseDto;

import java.io.IOException;

public interface VideoDiaryService {
    PostVideoDiaryResponseDto postVideoDiary(String id, PostVideoDiaryRequestDto dto) throws IOException;

    PostVideoDiaryResponseDto postUpdateVideoDiary(String id, Long videoDiaryId, PostUpdateVideoDiaryRequestDto dto);

//    TextDiaryDetailsResponseDto getDetails(String id, Long textDiaryId);
//
//    TextDiaryListResponseDto getList(String id, Integer year, Integer month);
//
//    void delete(String id, Long textDiaryId);
//
//    VideoSaveResponseDto videoSave() throws IOException;
}
