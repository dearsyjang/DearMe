package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.comment.CommentSaveRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentSaveResponseDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateResponseDto;

public interface CommentService {
    CommentSaveResponseDto commentSave(String id, Long boardid, CommentSaveRequestDto dto);

    CommentUpdateResponseDto updateComment(String id, Long commentid, CommentUpdateRequestDto dto);
    void deleteComment(String id, Long commentid);

}
