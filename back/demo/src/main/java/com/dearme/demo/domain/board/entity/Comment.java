package com.dearme.demo.domain.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentid;

    @Column(nullable = false)
    private Long boardid;

    @Column(nullable = false)
    private Long counselorid;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Comment(Long boardid, Long counselorid, Date date, String contents) {
        this.boardid = boardid;
        this.counselorid = counselorid;
        this.date = date;
        this.contents = contents;
    }

    public void update(String contents, Date date){
        this.contents=contents;
        this.date=date;
    }
}
