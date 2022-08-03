package com.dearme.demo.domain.board.dto.comment;

import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.user.entity.CounselorProfile;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
    private Board board;
    private CounselorProfile counselorProfile;
    private String date;
    private String contents;
}
