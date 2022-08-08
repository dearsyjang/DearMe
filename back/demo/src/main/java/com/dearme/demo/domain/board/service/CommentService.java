package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.comment.CommentSaveRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentSaveResponseDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateResponseDto;

public interface CommentService {
    CommentSaveResponseDto commentSave(String id, Long boardId, CommentSaveRequestDto dto);

    CommentUpdateResponseDto updateComment(String id, Long commentId, CommentUpdateRequestDto dto);
    void deleteComment(String id, Long commentId);

}
