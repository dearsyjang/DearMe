package com.dearme.demo.domain.videodiary.controller;

import com.dearme.demo.domain.videodiary.dto.PostUpdateVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.dto.PostVideoDiaryRequestDto;
import com.dearme.demo.domain.videodiary.service.VideoDiaryService;
import com.dearme.demo.global.common.CommonResponse;
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

}
