package com.dearme.demo.domain.board.dto.board;

import com.dearme.demo.domain.board.entity.Board;
import lombok.Data;

import java.util.Date;


@Data
public class BoardSaveRequestDto {
    private String title;
    private String contents;
    private Date date;
    public Board toBoardEntity(){
        return Board.builder()
                .title(this.title)
                .contents(this.contents)
                .date(this.date)
                .build();
    }
}
