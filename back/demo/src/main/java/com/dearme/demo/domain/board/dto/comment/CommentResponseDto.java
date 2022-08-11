package com.dearme.demo.domain.board.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class CommentResponseDto {
    private Long id;
    private Long user_id;
    private String nickName;
    private LocalDateTime date;
    private String contents;
}
