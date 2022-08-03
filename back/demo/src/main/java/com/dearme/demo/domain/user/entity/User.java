package com.dearme.demo.domain.user.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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


    @Builder
    public User(String id, String pw, String nickName, Gender gender,
                Date birth, String email, Type type, Picture picture, Long points){
        this.id = id;
        this.pw = pw;
        this.nickName = nickName;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.type = type;
        this.picture = picture;
        this.points = points;
    }

    @Builder
    public User(String id, String pw, String nickName, Gender gender,
                Date birth, String email, Type type, Picture picture,
                Long points, CounselorProfile counselorProfile){
        this.id = id;
        this.pw = pw;
        this.nickName = nickName;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.type = type;
        this.picture = picture;
        this.points = points;
        this.counselorProfile = counselorProfile;
    }
}
