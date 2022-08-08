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

    private String fileName;

    private String title;
    @Setter
    private String contents;
    @Setter
    private String sentiment;
    @Setter
    private Long percentage;

    private Integer year;

    private Integer month;

    private Integer day;

    @Builder
    public VideoDiary(String title, String contents, String sentiment, Long percentage, String realFileName, String fileName, Integer year, Integer month, Integer day){
        this.title = title;
        this.contents = contents;
        this.sentiment=sentiment;
        this.percentage=percentage;
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
    public void updatePercentage(Long percentage){this.percentage=percentage;}
    public void setUser(User user){
        this.user = user;
    }
}
