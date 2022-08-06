package com.dearme.demo.domain.counseling.entity;

import com.dearme.demo.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Counseling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private User counselor;

    @Enumerated(value = EnumType.STRING)
    private Type type;

    private Integer year;

    private Integer month;

    private Integer day;

    @Builder
    public Counseling(User user, User counselor, Integer year, Integer month, Integer day, Type type){
        this.user = user;
        this.counselor = counselor;
        this.year = year;
        this.month = month;
        this.day = day;
        this.type = type;
    }
}
