package com.dearme.demo.domain.videodiary.service;

import com.dearme.demo.domain.videodiary.dto.VideoDiaryPostRequestDto;
import com.dearme.demo.domain.videodiary.dto.VideoDiaryPostResponseDto;
import io.openvidu.java.client.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class VideoDiaryServiceImpl implements VideoDiaryService{

    private final Logger log = LoggerFactory.getLogger(VideoDiaryServiceImpl.class);

    private final OpenVidu openVidu;

    private Map<String, Session> mapSessions = new ConcurrentHashMap<>();
    private Map<String, Map<String, OpenViduRole>> mapSessionNamesTokens = new ConcurrentHashMap<>();

    @Override
    public String getToken(String id) {
        OpenViduRole role = OpenViduRole.PUBLISHER;
        ConnectionProperties connectionProperties = new ConnectionProperties
                .Builder()
                .type(ConnectionType.WEBRTC)
                .role(role)
                .build();

        RecordingProperties properties = new RecordingProperties.Builder()
                .outputMode(Recording.OutputMode.COMPOSED)
                .frameRate(24)
                .hasAudio(true)
                .hasVideo(true)
                .build();
        SessionProperties sessionProperties = new SessionProperties.Builder()
                .recordingMode(RecordingMode.MANUAL)
                .defaultRecordingProperties(properties)
                .build();
        try {
            Session session = openVidu.createSession(sessionProperties);
            String token = session.createConnection(connectionProperties).getToken();
            log.debug(token);
            this.mapSessions.put(id, session);
            this.mapSessionNamesTokens.put(id, new ConcurrentHashMap<>());
            this.mapSessionNamesTokens.get(id).put(token, role);
            return token;
        } catch (OpenViduJavaClientException e) {
            e.printStackTrace();
        } catch (OpenViduHttpException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VideoDiaryPostResponseDto recording(String id, VideoDiaryPostRequestDto dto) {
        RecordingProperties properties = new RecordingProperties.Builder()
                .name(UUID.randomUUID().toString())
                .build();
        try{
            Recording recording = openVidu.startRecording(id, properties);
            VideoDiaryPostResponseDto responseDto = new VideoDiaryPostResponseDto();
            responseDto.setRecording(recording);
            return responseDto;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
}