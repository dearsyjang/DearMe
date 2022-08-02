package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.BoardSaveRequestDto;
import com.dearme.demo.domain.board.dto.BoardUpdateRequestDto;
import com.dearme.demo.domain.board.dto.CommentSaveRequestDto;
import com.dearme.demo.domain.board.dto.CommentUpdateRequestDto;
import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;

public interface CommentService {
    Comment commentSave(CommentSaveRequestDto dto);

    Long updateComment(Long commentid, CommentUpdateRequestDto dto);
    void deleteComment(Long commentid);

}
