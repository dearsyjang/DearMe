package com.dearme.demo.domain.videodiary.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

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


    private String title;
    @Setter
    private String contents;

    @Setter
    private String sentiment;

    @Setter
    private Double percentage;
    @Setter
    private Double positive;
    @Setter
    private Double negative;
    @Setter
    private Double neutral;

    private Integer year;

    private Integer month;

    private Integer day;

    @Builder
    public VideoDiary(String title, String contents, String sentiment, double percentage, double positive, double negative, double neutral, String realFileName, Integer year, Integer month, Integer day){
        this.title = title;
        this.contents = contents;
        this.sentiment=sentiment;
        this.percentage=percentage;
        this.positive=positive;
        this.negative=negative;
        this.neutral=neutral;
        this.realFileName=realFileName;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void setSentimentInfo(String[] text, int save) {
        this.sentiment = text[save];
        this.percentage = Double.parseDouble(text[save+1]);
        this.positive = Double.parseDouble(text[save+2]);
        this.negative = Double.parseDouble(text[save+3]);
        this.neutral = Double.parseDouble(text[save+4]);
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
        user.getVideoDiaries().add(this);
        this.user = user;
    }
}
