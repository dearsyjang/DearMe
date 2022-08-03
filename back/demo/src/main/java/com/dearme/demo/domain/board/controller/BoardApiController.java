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

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardApiController {
    private final BoardService boardService;
    private final CommentService commentService;

    @Operation(summary = "Board Save Test", description = "게시판 글 저장")
    @PostMapping
    public ResponseEntity<CommonResponse> boardSave(String id, @RequestBody @Validated BoardSaveRequestDto dto){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.boardSave(id, dto)), HttpStatus.OK);
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
    @Operation(summary = "Board Update Test", description = "게시판 글 수정")
    @PutMapping("/{boardid}")
    public ResponseEntity<CommonResponse> boardUpdate(String id, @PathVariable("boardid") Long boardid, @RequestBody @Validated BoardUpdateRequestDto dto){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(boardService.updateBoard(id, boardid, dto)), HttpStatus.OK);
    }
    @Operation(summary = "Board Delete Test", description = "게시판 글 삭제")
    @DeleteMapping("/{boardid}")
    public ResponseEntity<CommonResponse> boardDelete(String id, @PathVariable("boardid") Long boardid){
        boardService.deleteBoard(id, boardid);
        return null;
    }
    @Operation(summary = "Comment Save Test", description = "게시판 댓글 저장")
    @PostMapping("/{boardid}/comments")
    public ResponseEntity<CommonResponse> commentSave(String id, @PathVariable("boardid") Long boardid, @RequestBody @Validated CommentSaveRequestDto dto){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(commentService.commentSave(id, boardid, dto)), HttpStatus.OK);
    }
    @Operation(summary = "Comment Update Test", description = "게시판 댓글 수정")  //댓글 수정 id -> request로 변경
    @PutMapping("/{boardid}/comments/{commentid}")
    public ResponseEntity<CommonResponse> commentUpdate(String id, @PathVariable("commentid") Long commentid, @RequestBody @Validated CommentUpdateRequestDto dto){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(commentService.updateComment(id, commentid, dto)), HttpStatus.OK);
    }
<<<<<<< back/demo/src/main/java/com/dearme/demo/domain/board/controller/BoardApiController.java
    @Operation(summary = "Comment Delete Test", description = "게시판 댓글 삭제")  //댓글 삭제 id -> request로 변경
=======
    @Operation(summary = "Comment Delete Test", description = "게시판 댓글 삭제")
>>>>>>> back/demo/src/main/java/com/dearme/demo/domain/board/controller/BoardApiController.java
    @DeleteMapping("/{boardid}/comments/{commentid}")
    public ResponseEntity<CommonResponse> commentDelete(String id, @PathVariable("commentid") Long commentid){
        commentService.deleteComment(id, commentid);
        return null;
    }
}
