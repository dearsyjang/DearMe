package com.dearme.demo.domain.board.dto;

import com.dearme.demo.domain.board.entity.Board;
import lombok.*;

import java.util.Date;


@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private Long userid;
    private String title;
    private String contents;

    private int hitCnt;
    private Date date;
    @Builder
    public BoardSaveRequestDto(Long userid, String title, String contents, int hitCnt, Date date){
        this.userid=userid;
        this.title=title;
        this.contents=contents;
        this.hitCnt = hitCnt;
        this.date=date;

    }
    public Board toBoardEntity(){
        return Board.builder()
                .userid(this.userid)
                .title(this.title)
                .contents(this.contents)
                .hitCnt(this.hitCnt)
                .date(this.date)
                .build();
    }
}
