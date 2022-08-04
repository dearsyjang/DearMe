package com.dearme.demo.domain.user.dto;

import com.dearme.demo.domain.user.entity.*;
import com.dearme.demo.domain.user.exception.CounselorProfileValidationException;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class SignUpRequestDto {
    @NotBlank(message = "id는 비워둘 수 없습니다.")
    private String id;

    @NotBlank(message = "pw는 비워둘 수 없습니다.")
    private String pw;

    @NotBlank(message = "nickname은 비워둘 수 없습니다.")
    private String nickName;

    @Email(message = "email 형식에 맞춰주세요.")
    @NotBlank(message = "email은 비워둘 수 없습니다.")
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

    public CounselorProfile toCounselorProfileEntity(){
        if(counselorProfile == null) throw new CounselorProfileValidationException();
        return CounselorProfile.builder()
                .introduce(counselorProfile.getIntroduce())
                .price(counselorProfile.getPrice())
                .value(0L)
                .build();
    }
}
