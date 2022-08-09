package com.dearme.demo.domain.board.dto.board;

import com.dearme.demo.domain.board.dto.comment.CommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class BoardViewResponseDto {
    private Long id;

    private String nickName;
    private String title;

    private String contents;

    private int hitCnt;

    private LocalDateTime date;

    private List<CommentResponseDto> comments;

}
