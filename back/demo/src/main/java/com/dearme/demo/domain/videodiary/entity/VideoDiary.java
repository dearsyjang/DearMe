package com.dearme.demo.domain.videodiary.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.review.entity.Favorite;
import com.dearme.demo.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class VideoDiary extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_diary_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String realFileName;

    private String fileName;

    private String title;
    @Setter
    private String contents;

    @Setter
    private String sentiment;

    @Setter
    private double percentage;
    @Setter
    private double positive;
    @Setter
    private double negative;
    @Setter
    private double neutral;

    private Integer year;

    private Integer month;

    private Integer day;

    @Builder
    public VideoDiary(String title, String contents, String sentiment, double percentage, double positive, double negative, double neutral, String realFileName, String fileName, Integer year, Integer month, Integer day){
        this.title = title;
        this.contents = contents;
        this.sentiment=sentiment;
        this.percentage=percentage;
        this.positive=positive;
        this.negative=negative;
        this.neutral=neutral;
        this.realFileName=realFileName;
        this.fileName=fileName;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void updateTitle(String title){
        this.title = title;
    }
    public void updateContents(String contents){
        this.contents = contents;
    }
    public void updateSentiment(String sentiment){
        this.sentiment = sentiment;
    }
    public void updatePercentage(double percentage){
        this.percentage = percentage;
    }
    public void updatePositive(double percentage){this.positive=percentage;}
    public void updateNegative(double percentage){this.negative=percentage;}
    public void updateNeutral(double percentage){this.neutral=percentage;}
    public void setUser(User user){
        this.user = user;
    }
}
