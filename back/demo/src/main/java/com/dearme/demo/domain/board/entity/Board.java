package com.dearme.demo.domain.board.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Board extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;
    @ManyToOne
    @JsonManagedReference // 순환참조 방지
    @JoinColumn(name="id")
    private User user;
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private int hitCnt=0;

    @Column(nullable = false)
    private LocalDateTime date;

    @OneToMany(mappedBy = "board", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonBackReference
    @Setter
    private List<Comment> comments=new ArrayList<>();

    public void setUser(User user){
        user.getBoards().add(this);
        this.user=user;
    }
    @Builder
    public Board(String title, String contents, int hitCnt, LocalDateTime date){
        this.title=title;
        this.contents=contents;
        this.hitCnt=hitCnt;
        this.date=date;
    }
    public void updateHitCnt(){
        this.hitCnt=this.hitCnt+1;
    }
    public void update(String title, String contents, LocalDateTime date){
        this.title=title;
        this.contents=contents;
        this.date=date;
    }
}
