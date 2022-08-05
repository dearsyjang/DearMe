package com.dearme.demo.domain.counsel.controller;

import com.dearme.demo.domain.board.dto.board.BoardSaveRequestDto;
import com.dearme.demo.domain.board.dto.board.BoardUpdateRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentSaveRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateRequestDto;
import com.dearme.demo.domain.board.service.BoardService;
import com.dearme.demo.domain.board.service.CommentService;
import com.dearme.demo.domain.counsel.service.CounselService;
import com.dearme.demo.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping("/videodiaries")
@RestController
public class CounselApiController {
    private final CounselService counselService;

    @Operation(summary = "Video Diary Test", description = "영상 일기 저장")
    @PostMapping
    public ResponseEntity<CommonResponse> videoDiarySave(){     //영상 일기 기능 완성 시 파라미터 추가 필요
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(counselService.videoSave()), HttpStatus.OK);
    }
}
