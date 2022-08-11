package com.dearme.demo.domain.recordingroom.service;

import com.dearme.demo.domain.recordingroom.dto.GetSessionTokenResponseDto;
import com.dearme.demo.domain.recordingroom.dto.RecordingResponseDto;
import io.openvidu.java.client.Recording;

public interface RecordingRoomService {
    GetSessionTokenResponseDto getSessionToken();
    RecordingResponseDto getStartRecording(String sessionId, boolean hasAudio, boolean hasVideo, Recording.OutputMode outputMode);
    RecordingResponseDto getStopRecording(String recordingId);

    void deleteRecording(String recordingId);

}
