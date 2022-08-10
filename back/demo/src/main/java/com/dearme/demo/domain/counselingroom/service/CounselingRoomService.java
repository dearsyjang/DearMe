package com.dearme.demo.domain.counselingroom.service;

import com.dearme.demo.domain.counselingroom.dto.CreateCounselingRoomRequestDto;
import com.dearme.demo.domain.counselingroom.dto.CreateCounselingRoomResponseDto;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;

public interface CounselingRoomService {
    CreateCounselingRoomResponseDto createCounselingRoom(String id, CreateCounselingRoomRequestDto dto) throws OpenViduJavaClientException, OpenViduHttpException;
}
