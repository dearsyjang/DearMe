package com.dearme.demo.domain.textdiary.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TextDiary extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String contents;

    @Builder
    public TextDiary(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public void setUser(User user){
        this.user = user;
    }
}
