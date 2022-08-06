package com.dearme.demo.domain.counselingdocument.entity;

import com.dearme.demo.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CounselingDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private User counselor;

    private Integer year;

    private Integer month;

    private Integer day;

    private String contents;

    private Boolean isOpen;

    public void setUser(User user){
        this.user = user;
    }

    public void setCounselor(User counselor){
        this.counselor = counselor;
    }

    @Builder
    public CounselingDocument(Integer year, Integer month, Integer day, String contents, Boolean isOpen){
        this.year = year;
        this.month = month;
        this.day = day;
        this.contents = contents;
        this.isOpen = isOpen;
    }
}
