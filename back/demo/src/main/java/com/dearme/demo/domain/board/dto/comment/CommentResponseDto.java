package com.dearme.demo.domain.board.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CommentResponseDto {
    private String name;
    private Date date;
    private String contents;
}
