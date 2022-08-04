package com.dearme.demo.domain.board.dto.board;

import com.dearme.demo.domain.board.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class BoardsViewResponseDto {
    private Long boardid;

    private String nickname;

    private String title;


    private int hitcnt;

    private Date date;


}
