package com.dearme.demo.domain.videodiary.dto;

import io.openvidu.java.client.Recording;
import lombok.Data;

@Data
public class VideoDiaryPostResponseDto {
    private Recording recording;
}
