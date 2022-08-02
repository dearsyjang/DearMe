package com.dearme.demo.domain.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardid;

    @Column(nullable = false)
    private Long userid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private int hitCnt=0;

    @Column(nullable = false)
    private Date date;

    @Builder
    public Board(Long userid, String title, String contents, int hitCnt, Date date){
        this.userid=userid;
        this.title=title;
        this.contents=contents;
        this.hitCnt=hitCnt;
        this.date=date;
    }
    public void updateHitCnt(){
        this.hitCnt=this.hitCnt+1;
    }
    public void update(String title, String contents, Date date){
        this.title=title;
        this.contents=contents;
        this.date=date;
    }
}
