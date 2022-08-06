package com.dearme.demo.domain.videodiary.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.user.entity.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class VideoDiary extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long year;

    private Long month;

    private Long day;

    private String filePath;

    private String contents;

    public void updateContents(String contents){
        this.contents = contents;
    }
}
