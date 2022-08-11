package com.dearme.demo.domain.recordingroom.controller;

import com.dearme.demo.domain.recordingroom.dto.GetSessionTokenResponseDto;
import com.dearme.demo.domain.recordingroom.service.RecordingRoomService;
import com.dearme.demo.global.common.CommonResponse;
import com.google.gson.JsonObject;
import io.openvidu.java.client.Recording;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/recording")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})
public class RecordingRoomController {

    private final RecordingRoomService recordingRoomService;

    /*******************/
    /** Recording API **/
    /*******************/
    @RequestMapping(value = "/get-token", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getSessionToken(HttpServletRequest request){
        //String id = (String) request.getAttribute("id");
        return ResponseEntity.ok().body(CommonResponse.getSuccessResponse(recordingRoomService.getSessionToken()));
    }
    @RequestMapping(value = "/recording/start", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> startRecording(@RequestBody Map<String, Object> params) {
        String sessionId = (String) params.get("session");
        boolean hasAudio = (boolean) params.get("hasAudio");
        boolean hasVideo = (boolean) params.get("hasVideo");
        Recording.OutputMode outputMode = Recording.OutputMode.valueOf((String) params.get("outputMode"));
        return ResponseEntity.ok().body(CommonResponse.getSuccessResponse(recordingRoomService.getStartRecording(sessionId, hasAudio, hasVideo, outputMode)));
    }


    }


}
