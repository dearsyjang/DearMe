package com.dearme.demo.domain.board.dto.board;

import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class BoardViewResponseDto {
    private Long boardid;

    private User user;
    private String title;

    private String contents;

    private int hitCnt;

    private Date date;

    private List<Comment> comments;

}
