package com.dearme.demo.domain.board.controller;

import com.dearme.demo.domain.board.dto.BoardSaveRequestDto;
import com.dearme.demo.domain.board.dto.BoardUpdateRequestDto;
import com.dearme.demo.domain.board.dto.CommentSaveRequestDto;
import com.dearme.demo.domain.board.dto.CommentUpdateRequestDto;
import com.dearme.demo.domain.board.service.BoardService;
import com.dearme.demo.domain.board.service.CommentService;
import com.dearme.demo.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardApiController {
    private final BoardService boardService;
    private final CommentService commentService;

    @Operation(summary = "Board Save Test", description = "게시판 글 저장")
    @PostMapping
    public ResponseEntity<CommonResponse> boardSave(@RequestBody @Validated BoardSaveRequestDto dto){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.boardSave(dto)), HttpStatus.OK);
    }
    @Operation(summary = "Board View Test", description = "게시판 전체 조회")
    @GetMapping
    public ResponseEntity<CommonResponse> boardView(@RequestParam("page") Integer page, @RequestParam("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.getBoards(pageRequest)), HttpStatus.OK);
    }
    @Operation(summary = "Board View Detail Test", description = "게시판 상세 조회")
    @GetMapping("/{boardid}")
    public ResponseEntity<CommonResponse> boardViewDetail(@PathVariable("boardid") Long boardid){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.getBoard(boardid)), HttpStatus.OK);
    }
    @Operation(summary = "Board Update Test", description = "게시판 수정")
    @PutMapping("/{boardid}")
    public ResponseEntity<CommonResponse> boardUpdate(@PathVariable("boardid") Long boardid, @RequestBody @Validated BoardUpdateRequestDto dto){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.updateBoard(boardid, dto)), HttpStatus.OK);
    }
    @Operation(summary = "Board Delete Test", description = "게시판 삭제")
    @DeleteMapping("/{boardid}")
    public ResponseEntity<CommonResponse> boardDelete(@PathVariable("boardid") Long boardid){
        boardService.deleteBoard(boardid);
        return null;
    }
}