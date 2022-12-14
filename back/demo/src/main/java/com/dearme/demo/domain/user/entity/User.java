package com.dearme.demo.domain.user.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import com.dearme.demo.domain.favorite.entity.Favorite;
import com.dearme.demo.domain.group.entity.Group;

import com.dearme.demo.domain.favorite.entity.Favorite;
import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private Date birth;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;
    @Embedded
    @Setter
    private Picture picture;

    @Column(nullable = false)
    private Long points;

    @Column(nullable = false)
    private String refreshToken;

    @OneToOne(mappedBy = "counselor", orphanRemoval = true, cascade = CascadeType.ALL)
    private CounselorProfile counselorProfile;

    public void setCounselorProfile(CounselorProfile counselorProfile) {
        counselorProfile.setCounselor(this);
        this.counselorProfile = counselorProfile;
    }

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Review> reviews = new ArrayList<>();


    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    @Setter
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "counselor", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Group> groups = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<GroupUser> groupUsers = new ArrayList<>();

    @OneToMany(mappedBy = "counselor", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Counseling> counselorCounselings = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Counseling> userCounselings = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TextDiary> textDiaries = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<VideoDiary> videoDiaries = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CounselingDocument> userCounselingDocuments = new ArrayList<>();

    @OneToMany(mappedBy = "counselor", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CounselingDocument> counselorCounselingDocuments = new ArrayList<>();

    public void updateUser(String pw, String nickName){
        this.pw = pw;
        this.nickName = nickName;
    }

    public void updateCounselor(String pw, String nickName, CounselorProfile counselorProfile){
        this.pw = pw;
        this.nickName = nickName;
        this.counselorProfile = counselorProfile;
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public void updatePoints(Long points){
        this.points = points + this.points;
    }

    public void updateImage(Picture picture){
        this.picture = picture;
    }

    @Builder
    public User(String id, String pw, String nickName, Gender gender,
                Date birth, String email, String phone, Type type, Picture picture, Long points){
        this.id = id;
        this.pw = pw;
        this.nickName = nickName;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.phone=phone;
        this.type = type;
        this.picture = picture;
        this.points = points;
    }

    @Builder
    public User(String id, String pw, String nickName, Gender gender,
                Date birth, String email, String phone, Type type, Picture picture,
                Long points, CounselorProfile counselorProfile){
        this.id = id;
        this.pw = pw;
        this.nickName = nickName;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.phone=phone;
        this.type = type;
        this.picture = picture;
        this.points = points;
        this.counselorProfile = counselorProfile;
    }
}
