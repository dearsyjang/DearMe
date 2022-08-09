package com.dearme.demo.domain.board.controller;

import com.dearme.demo.domain.board.dto.board.BoardSaveRequestDto;
import com.dearme.demo.domain.board.dto.board.BoardUpdateRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentSaveRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateRequestDto;
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

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardApiController {
    private final BoardService boardService;
    private final CommentService commentService;

    @Operation(summary = "Board Save Test", description = "게시판 글 저장")
    @PostMapping
    public ResponseEntity<CommonResponse> boardSave(HttpServletRequest request, @RequestBody @Validated BoardSaveRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.boardSave(id, dto)), HttpStatus.OK);
    }
    @Operation(summary = "Board View Test", description = "게시판 전체 조회")
    @GetMapping
    public ResponseEntity<CommonResponse> boardView(@RequestParam("page") Integer page, @RequestParam("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.getBoards(pageRequest)), HttpStatus.OK);
    }
    @Operation(summary = "Board View Detail Test", description = "게시판 상세 조회")
    @GetMapping("/{boardId}")
    public ResponseEntity<CommonResponse> boardViewDetail(@PathVariable("boardId") Long boardId){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.getBoard(boardId)), HttpStatus.OK);
    }
    @Operation(summary = "Board Update Test", description = "게시판 글 수정")
    @PutMapping("/{boardId}")
    public ResponseEntity<CommonResponse> boardUpdate(HttpServletRequest request, @PathVariable("boardId") Long boardId, @RequestBody @Validated BoardUpdateRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.updateBoard(id, boardId, dto)), HttpStatus.OK);
    }
    @Operation(summary = "Board Delete Test", description = "게시판 글 삭제")
    @DeleteMapping("/{boardId}")
    public ResponseEntity<CommonResponse> boardDelete(HttpServletRequest request, @PathVariable("boardId") Long boardId){
        String id = (String) request.getAttribute("id");
        boardService.deleteBoard(id, boardId);
        return null;
    }
    @Operation(summary = "Comment Save Test", description = "게시판 댓글 저장")
    @PostMapping("/{boardId}/comments")
    public ResponseEntity<CommonResponse> commentSave(HttpServletRequest request, @PathVariable("boardId") Long boardId, @RequestBody @Validated CommentSaveRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(commentService.commentSave(id, boardId, dto)), HttpStatus.OK);
    }
    @Operation(summary = "Comment Update Test", description = "게시판 댓글 수정")  //댓글 수정 id -> request로 변경
    @PutMapping("/{boardId}/comments/{commentId}")
    public ResponseEntity<CommonResponse> commentUpdate(HttpServletRequest request, @PathVariable("commentId") Long commentId, @RequestBody @Validated CommentUpdateRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(commentService.updateComment(id, commentId, dto)), HttpStatus.OK);
    }
    @Operation(summary = "Comment Delete Test", description = "게시판 댓글 삭제")
    @DeleteMapping("/{boardId}/comments/{commentId}")
    public ResponseEntity<CommonResponse> commentDelete(HttpServletRequest request, @PathVariable("commentId") Long commentId){
        String id = (String) request.getAttribute("id");
        commentService.deleteComment(id, commentId);
        return null;
    }
}
