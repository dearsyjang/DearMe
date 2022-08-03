package com.dearme.demo.domain.board.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentid;

    @ManyToOne
    @JsonManagedReference // 순환참조 방지
    @JoinColumn(name="boardid")
    private Board board;

    @ManyToOne
    @JsonManagedReference // 순환참조 방지
    @JoinColumn(name="id")
    private User user;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String contents;


    public void setBoard(Board board){
        board.getComments().add(this);
        this.board=board;
    }
    public void setUser(User user){
        user.getComments().add(this);
        this.user=user;
    }
    @Builder
    public Comment(Date date, String contents) {
        this.date = date;
        this.contents = contents;
    }

    public void update(String contents, Date date){
        this.contents=contents;
        this.date=date;
    }
}
