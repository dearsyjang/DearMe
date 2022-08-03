package com.dearme.demo.domain.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentResponseDto {
    private Long boardid;
    private Long counselorid;
    private String date;
    private String contents;
}
