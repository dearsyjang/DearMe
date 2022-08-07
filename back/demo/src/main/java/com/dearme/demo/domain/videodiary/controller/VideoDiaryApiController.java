package com.dearme.demo.domain.videodiary.controller;

import com.dearme.demo.domain.videodiary.service.VideoDiaryService;
import com.dearme.demo.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/videodiaries")
@RestController
public class VideoDiaryApiController {
    private final VideoDiaryService counselService;

    @Operation(summary = "Video Diary Test", description = "영상 일기 저장")
    @PostMapping
    public ResponseEntity<CommonResponse> videoDiarySave() throws IOException {     //영상 일기 기능 완성 시 파라미터 추가 필요
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(counselService.videoSave()), HttpStatus.OK);
    }
}
