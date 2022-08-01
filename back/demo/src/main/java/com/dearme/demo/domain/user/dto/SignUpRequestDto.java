package com.dearme.demo.domain.user.dto;

import com.dearme.demo.domain.user.entity.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class SignUpRequestDto {
    private String id;

    private String pw;

    private String nickName;

    private String email;

    private Date birth;

    private Gender gender;

    private Type type;

    private MultipartFile picture;

    private CounselorProfileRequestDto counselorProfile;

    public User toUserEntity(){
        return User.builder()
                .id(this.id).pw(this.pw).nickName(this.nickName)
                .email(this.email).birth(this.birth).gender(this.gender)
                .points(0L).type(this.type).build();
    }

    public User toCounselorEntity(){
        return User.builder()
                .id(this.id).pw(this.pw).nickName(this.nickName)
                .email(this.email).birth(this.birth).gender(this.gender)
                .points(0L).type(this.type).build();
    }

    public CounselorProfile toCounselorProfileEntity(){
        return CounselorProfile.builder()
                .introduce(counselorProfile.getIntroduce())
                .price(counselorProfile.getPrice())
                .build();
    }
}
