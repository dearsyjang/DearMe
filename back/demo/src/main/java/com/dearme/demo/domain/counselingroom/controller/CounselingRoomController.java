package com.dearme.demo.domain.counselingroom.controller;

import com.dearme.demo.domain.counselingroom.dto.CreateCounselingRoomRequestDto;
import com.dearme.demo.domain.counselingroom.service.CounselingRoomServiceImpl;
import com.dearme.demo.global.common.CommonResponse;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/counseling-rooms")
@RequiredArgsConstructor
public class CounselingRoomController {

    private final CounselingRoomServiceImpl counselingRoomService;

    @PostMapping
    public ResponseEntity<CommonResponse> createCounselingRoom(HttpServletRequest request, @RequestBody CreateCounselingRoomRequestDto dto) throws OpenViduJavaClientException, OpenViduHttpException {
        String id = (String) request.getAttribute("id");
        return ResponseEntity.accepted().body(CommonResponse.getSuccessResponse(counselingRoomService.createCounselingRoom(id, dto)));
    }

    @GetMapping("/{counselingId}")
    public ResponseEntity<CommonResponse> getSessionToken(HttpServletRequest request, @PathVariable("counselingId") Long counselingId){
        String id = (String) request.getAttribute("id");
        return ResponseEntity.ok().body(CommonResponse.getSuccessResponse(counselingRoomService.getSessionToken(id, counselingId)));
    }
}
