package com.dearme.demo.domain.board.dto;

import com.dearme.demo.domain.board.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BoardResponseDto {
    private Long userid;
    private String title;
    private String contents;
    private int hitCnt;
    private Date date;
    private List<Comment> comment;
}
