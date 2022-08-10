package com.dearme.demo.domain.videodiary.controller;

import com.dearme.demo.domain.videodiary.dto.PostUpdateVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.dto.PostVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.service.VideoDiaryService;
import com.dearme.demo.global.common.CommonResponse;
import com.google.gson.JsonObject;
import io.openvidu.java.client.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@RequestMapping("/video-diaries")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})
public class VideoDiaryApiController {
    private final VideoDiaryService videoDiaryService;

    private final OpenVidu openvidu;
    // Collection to pair session names and OpenVidu Session objects
    private Map<String, Session> mapSessions = new ConcurrentHashMap<>();
    // Collection to pair session names and tokens (the inner Map pairs tokens and
    // role associated)
    private Map<String, Map<String, OpenViduRole>> mapSessionNamesTokens = new ConcurrentHashMap<>();
    // Collection to pair session names and recording objects
    private Map<String, Boolean> sessionRecordings = new ConcurrentHashMap<>();
    @PostMapping
    public ResponseEntity<CommonResponse> postDiary(HttpServletRequest request, @RequestBody PostVideoDiaryRequestDto dto) throws IOException {

        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(videoDiaryService.postVideoDiary(id, dto)), HttpStatus.OK);

    }

    @PutMapping("/{videoDiaryId}")
    public ResponseEntity<CommonResponse> postUpdateDiary(HttpServletRequest request, @PathVariable Long videoDiaryId, @RequestBody PostUpdateVideoDiaryRequestDto dto) throws IOException {
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(videoDiaryService.postUpdateVideoDiary(id, videoDiaryId, dto)), HttpStatus.OK);
    }

    @GetMapping("/{videoDiaryId}")
    public ResponseEntity<CommonResponse> getDetails(HttpServletRequest request, @PathVariable Long videoDiaryId){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(videoDiaryService.getDetails(id, videoDiaryId)), HttpStatus.OK);
    }
    @GetMapping("/year/{year}/month/{month}")
    public ResponseEntity<CommonResponse> getList(HttpServletRequest request, @PathVariable("year") Integer year, @PathVariable("month") Integer month){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(videoDiaryService.getList(id, year, month)), HttpStatus.OK);
    }
    @DeleteMapping("/{videoDiaryId}")
    public void delete(HttpServletRequest request, @PathVariable Long videoDiaryId){
        String id = (String) request.getAttribute("id");
        videoDiaryService.delete(id, videoDiaryId);
    }
    /*******************/
    /** Recording API **/
    /*******************/

    @RequestMapping(value = "/recording/start", method = RequestMethod.POST)
    public ResponseEntity<?> startRecording(@RequestBody Map<String, Object> params) {
        String sessionId = (String) params.get("session");
        Recording.OutputMode outputMode = Recording.OutputMode.valueOf((String) params.get("outputMode"));
        boolean hasAudio = (boolean) params.get("hasAudio");
        boolean hasVideo = (boolean) params.get("hasVideo");

        RecordingProperties properties = new RecordingProperties.Builder().outputMode(outputMode).hasAudio(hasAudio)
                .hasVideo(hasVideo).build();

        System.out.println("Starting recording for session " + sessionId + " with properties {outputMode=" + outputMode
                + ", hasAudio=" + hasAudio + ", hasVideo=" + hasVideo + "}");

        try {
            Recording recording = openvidu.startRecording(sessionId, properties);
            this.sessionRecordings.put(sessionId, true);
            return new ResponseEntity<>(recording, HttpStatus.OK);
        } catch (OpenViduJavaClientException | OpenViduHttpException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/recording/stop", method = RequestMethod.POST)
    public ResponseEntity<?> stopRecording(@RequestBody Map<String, Object> params) {
        String recordingId = (String) params.get("recording");

        System.out.println("Stoping recording | {recordingId}=" + recordingId);

        try {
            Recording recording = openvidu.stopRecording(recordingId);
            this.sessionRecordings.remove(recording.getSessionId());
            return new ResponseEntity<>(recording, HttpStatus.OK);
        } catch (OpenViduJavaClientException | OpenViduHttpException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/recording/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRecording(@RequestBody Map<String, Object> params) {
        String recordingId = (String) params.get("recording");

        System.out.println("Deleting recording | {recordingId}=" + recordingId);

        try {
            openvidu.deleteRecording(recordingId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (OpenViduJavaClientException | OpenViduHttpException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/recording/get/{recordingId}", method = RequestMethod.GET)
    public ResponseEntity<?> getRecording(@PathVariable(value = "recordingId") String recordingId) {

        System.out.println("Getting recording | {recordingId}=" + recordingId);

        try {
            Recording recording = openvidu.getRecording(recordingId);
            return new ResponseEntity<>(recording, HttpStatus.OK);
        } catch (OpenViduJavaClientException | OpenViduHttpException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/get-token", method = RequestMethod.POST)
    public ResponseEntity<JsonObject> getToken(@RequestBody Map<String, Object> sessionNameParam) {

        System.out.println("Getting sessionId and token | {sessionName}=" + sessionNameParam);

        // The video-call to connect ("TUTORIAL")
        String sessionName = (String) sessionNameParam.get("sessionName");

        // Role associated to this user
        OpenViduRole role = OpenViduRole.PUBLISHER;

        // Build connectionProperties object with the serverData and the role
        ConnectionProperties connectionProperties = new ConnectionProperties.Builder().type(ConnectionType.WEBRTC)
                .role(role).data("user_data").build();

        JsonObject responseJson = new JsonObject();

        if (this.mapSessions.get(sessionName) != null) {
            // Session already exists
            System.out.println("Existing session " + sessionName);
            try {

                // Generate a new token with the recently created connectionProperties
                String token = this.mapSessions.get(sessionName).createConnection(connectionProperties).getToken();

                // Update our collection storing the new token
                this.mapSessionNamesTokens.get(sessionName).put(token, role);

                // Prepare the response with the token
                responseJson.addProperty("0", token);

                // Return the response to the client
                return new ResponseEntity<>(responseJson, HttpStatus.OK);

            } catch (OpenViduJavaClientException e1) {
                // If internal error generate an error message and return it to client
                return getErrorResponse(e1);
            } catch (OpenViduHttpException e2) {
                if (404 == e2.getStatus()) {
                    // Invalid sessionId (user left unexpectedly). Session object is not valid
                    // anymore. Clean collections and continue as new session
                    this.mapSessions.remove(sessionName);
                    this.mapSessionNamesTokens.remove(sessionName);
                }
            }
        }

        // New session
        System.out.println("New session " + sessionName);
        try {

            // Create a new OpenVidu Session
            Session session = openvidu.createSession();
            // Generate a new token with the recently created connectionProperties
            String token = session.createConnection(connectionProperties).getToken();

            // Store the session and the token in our collections
            this.mapSessions.put(sessionName, session);
            this.mapSessionNamesTokens.put(sessionName, new ConcurrentHashMap<>());
            this.mapSessionNamesTokens.get(sessionName).put(token, role);

            // Prepare the response with the sessionId and the token
            responseJson.addProperty("0", token);

            // Return the response to the client
            return new ResponseEntity<>(responseJson, HttpStatus.OK);

        } catch (Exception e) {
            // If error generate an error message and return it to client
            return getErrorResponse(e);
        }
    }
    private ResponseEntity<JsonObject> getErrorResponse(Exception e) {
        JsonObject json = new JsonObject();
        json.addProperty("cause", e.getCause().toString());
        json.addProperty("error", e.getMessage());
        json.addProperty("exception", e.getClass().getCanonicalName());
        return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
