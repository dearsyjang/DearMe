package com.dearme.demo.domain.user.entity;

import com.dearme.demo.domain.base.entitiy.Base;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private String id;

    private String pw;

    private String nickName;

    private Gender gender;

    private Type type;

    private Date birth;

    private String email;

    @Embedded
    private Picture picture;

    private Long points;

    @OneToOne(mappedBy = "counselor", orphanRemoval = true, cascade = CascadeType.ALL)
    private CounselorProfile counselorProfile;

    public void setCounselorProfile(CounselorProfile counselorProfile) {
        this.counselorProfile = counselorProfile;
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
