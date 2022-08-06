package com.dearme.demo.domain.videodiary.controller;

import com.dearme.demo.domain.videodiary.dto.VideoDiaryPostRequestDto;
import com.dearme.demo.domain.videodiary.service.VideoDiaryServiceImpl;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/video-diaries")
@RequiredArgsConstructor
public class VideoDiaryController {

    private final VideoDiaryServiceImpl videoDiaryService;

    @GetMapping
    public ResponseEntity<CommonResponse> getOpenViduToken(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(videoDiaryService.getToken(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommonResponse> recordingVideoDiary(HttpServletRequest request, @RequestBody VideoDiaryPostRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(videoDiaryService.recording(id, dto)), HttpStatus.OK);
    }
}