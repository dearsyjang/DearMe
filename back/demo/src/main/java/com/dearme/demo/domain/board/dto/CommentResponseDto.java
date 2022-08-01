package com.dearme.demo.domain.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {
    private Long boardid;
    private String counselorid;
    private String date;
    private String contents;
}
