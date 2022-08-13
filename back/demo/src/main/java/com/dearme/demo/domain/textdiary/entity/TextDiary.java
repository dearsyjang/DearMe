package com.dearme.demo.domain.textdiary.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TextDiary extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "text_diary_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

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
    public TextDiary(String title, String contents,Integer year, Integer month, Integer day){
        this.title = title;
        this.contents = contents;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setUser(User user){
        user.getTextDiaries().add(this);
        this.user = user;
    }

    public void setSentimentInfo(String[] text) {
        this.sentiment = text[0];
        this.percentage = Double.parseDouble(text[1]);
        this.positive = Double.parseDouble(text[2]);
        this.negative = Double.parseDouble(text[3]);
        this.neutral = Double.parseDouble(text[4]);
    }
}
