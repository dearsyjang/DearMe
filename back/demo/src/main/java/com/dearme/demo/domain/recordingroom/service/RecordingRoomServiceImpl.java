package com.dearme.demo.domain.recordingroom.service;

import com.dearme.demo.domain.recordingroom.dto.GetSessionTokenResponseDto;
import com.dearme.demo.domain.recordingroom.dto.RecordingResponseDto;
import com.dearme.demo.domain.recordingroom.exception.*;
import com.dearme.demo.domain.review.exception.NoReviewSavePermissionException;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import io.openvidu.java.client.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.NoPermissionException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class RecordingRoomServiceImpl implements RecordingRoomService {


    private final UserRepository userRepository;
    private final OpenVidu openvidu;
    // Collection to pair session names and OpenVidu Session objects
    private Map<String, Session> mapSessions = new ConcurrentHashMap<>();
    // Collection to pair session names and tokens (the inner Map pairs tokens and
    // role associated)
    private Map<String, Map<String, OpenViduRole>> mapSessionNamesTokens = new ConcurrentHashMap<>();
    // Collection to pair session names and recording objects
    private Map<String, Boolean> sessionRecordings = new ConcurrentHashMap<>();


    @Override
    public GetSessionTokenResponseDto getSessionToken(String id) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getType().equals(Type.COUNSELOR)){
            throw new NoRecordingPermissionException();
        }

        OpenViduRole role = OpenViduRole.PUBLISHER;

        // Build connectionProperties object with the serverData and the role
        ConnectionProperties connectionProperties = new ConnectionProperties.Builder().type(ConnectionType.WEBRTC)
                .role(role).build();

        Session session;
        String token="";
        try {
            // Create a new OpenVidu Session
            session = openvidu.createSession();
            // Generate a new token with the recently created connectionProperties
            token = session.createConnection(connectionProperties).getToken();
        } catch (Exception e) {
            throw new RecordingGetTokenException();
        }
        return GetSessionTokenResponseDto.of(token);
    }

    @Override
    public RecordingResponseDto getStartRecording(String sessionId, boolean hasAudio, boolean hasVideo, Recording.OutputMode outputMode) {

        RecordingProperties properties = new RecordingProperties.Builder().outputMode(outputMode).hasAudio(hasAudio)
                .hasVideo(hasVideo).build();
        Recording recording = null;
        try {
            recording = openvidu.startRecording(sessionId, properties);
            this.sessionRecordings.put(sessionId, true);
        } catch (OpenViduJavaClientException | OpenViduHttpException e) {
            throw new RecordingStartException();
        }
        return RecordingResponseDto.of(recording);
    }

    @Override
    public RecordingResponseDto getStopRecording(String recordingId) {
        Recording recording = null;
        try {
            recording = openvidu.stopRecording(recordingId);
            this.sessionRecordings.remove(recording.getSessionId());
        } catch (OpenViduJavaClientException | OpenViduHttpException e) {
            throw new RecordingStopException();
        }
        return RecordingResponseDto.of(recording);
    }

    @Override
    public void deleteRecording(String recordingId) {
        try {
            openvidu.deleteRecording(recordingId);
        }catch (Exception e){
            throw new RecordingDeleteException();
        }
    }

    @Override
    public RecordingResponseDto getRecording(String recordingId) {
        Recording recording = null;
        try {
            recording = openvidu.getRecording(recordingId);
        }catch (Exception e){
            throw new RecordingGetException();
        }
        return RecordingResponseDto.of(recording);
    }
}
