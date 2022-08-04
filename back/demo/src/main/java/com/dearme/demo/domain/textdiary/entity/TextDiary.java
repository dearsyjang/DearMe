package com.dearme.demo.domain.textdiary.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.user.entity.User;

import javax.persistence.*;

@Entity
public class TextDiary extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String contents;

    public void setUser(User user){
        this.user = user;
    }
}
