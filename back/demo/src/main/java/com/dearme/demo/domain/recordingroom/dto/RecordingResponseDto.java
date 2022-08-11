package com.dearme.demo.domain.recordingroom.dto;

import io.openvidu.java.client.Recording;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecordingResponseDto {
    Recording recording;

    public static RecordingResponseDto of(Recording recording){
        return RecordingResponseDto.builder().recording(recording).build();
    }
}
