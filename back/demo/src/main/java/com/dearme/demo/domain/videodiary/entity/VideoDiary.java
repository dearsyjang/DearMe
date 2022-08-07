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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String realfilename;

    private String filename;

    private String title;
    @Setter
    private String contents;
    @Setter
    private String sentiment;

    private Integer year;

    private Integer month;

    private Integer day;

    @Builder
    public VideoDiary(String title, String contents, String sentiment, String realfilename, String filename, Integer year, Integer month, Integer day){
        this.title = title;
        this.contents = contents;
        this.sentiment=sentiment;
        this.realfilename=realfilename;
        this.filename=filename;
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
    public void setUser(User user){
        this.user = user;
    }
}
