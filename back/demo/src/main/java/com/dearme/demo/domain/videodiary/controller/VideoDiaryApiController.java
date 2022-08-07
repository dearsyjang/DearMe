package com.dearme.demo.domain.videodiary.controller;

import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.service.TextDiaryService;
import com.dearme.demo.domain.videodiary.dto.PostUpdateVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.dto.PostVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.service.VideoDiaryService;
import com.dearme.demo.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/video-diaries")
@RestController
public class VideoDiaryApiController {
    private final VideoDiaryService videoDiaryService;

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

//    @GetMapping("/{textDiaryId}")
//    public ResponseEntity<CommonResponse> getDetails(HttpServletRequest request, @PathVariable Long textDiaryId){
//        String id = (String) request.getAttribute("id");
//        return new ResponseEntity<>(CommonResponse.getSuccessResponse(textDiaryService.getDetails(id, textDiaryId)), HttpStatus.OK);
//    }
//    @GetMapping("/year/{year}/month/{month}")
//    public ResponseEntity<CommonResponse> getList(HttpServletRequest request, @PathVariable("year") Integer year, @PathVariable("month") Integer month){
//        String id = (String) request.getAttribute("id");
//        return new ResponseEntity<>(CommonResponse.getSuccessResponse(textDiaryService.getList(id, year, month)), HttpStatus.OK);
//    }
//    @DeleteMapping("/{textDiaryId}")
//    public void delete(HttpServletRequest request, @PathVariable Long textDiaryId){
//        String id = (String) request.getAttribute("id");
//        textDiaryService.delete(id, textDiaryId);
//    }
//
//
//    @Operation(summary = "Video Diary Test", description = "영상 일기 저장")
//    @PostMapping
//    public ResponseEntity<CommonResponse> videoDiarySave() throws IOException {     //영상 일기 기능 완성 시 파라미터 추가 필요
//        return new ResponseEntity<>(CommonResponse.getSuccessResponse(counselService.videoSave()), HttpStatus.OK);
//    }
}
