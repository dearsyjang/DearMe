package com.dearme.demo.domain.videodiary.service;

import com.dearme.demo.domain.videodiary.dto.VideoSaveResponseDto;

import java.io.IOException;

public interface VideoDiaryService {
    VideoSaveResponseDto videoSave() throws IOException;
}
