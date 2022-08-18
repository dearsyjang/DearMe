package com.dearme.demo.domain.user.dto.user;

import com.dearme.demo.domain.user.dto.counselorprofile.CounselorProfileInfoDto;
import com.dearme.demo.domain.user.entity.Gender;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
public class UserInfoResponseDto {
    private Long userId;
    private String id;
    private String pw;
    private String nickname;
    private String email;
    private String phone;
    private Gender gender;
    private Type type;
    private String pictureUrl;
    private Long points;
    private CounselorProfileInfoDto counselorProfileInfoDto;

    public static UserInfoResponseDto ofUser(User user){
        return UserInfoResponseDto.builder()
                .userId(user.getUserId())
                .id(user.getId())
                .pw(user.getPw())
                .nickname(user.getNickName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .gender(user.getGender())
                .type(user.getType())
                .pictureUrl("https://i7d206.p.ssafy.io/api/users/" + user.getUserId() + "/image")
                .points(user.getPoints())
                .build();
    }

    public static UserInfoResponseDto ofCounselor(User counselor){
        return UserInfoResponseDto.builder()
                .userId(counselor.getUserId())
                .id(counselor.getId())
                .pw(counselor.getPw())
                .nickname(counselor.getNickName())
                .email(counselor.getEmail())
                .phone(counselor.getPhone())
                .gender(counselor.getGender())
                .type(counselor.getType())
//                .pictureUrl(counselor.getPicture().getRealFileName())
                .pictureUrl("https://i7d206.p.ssafy.io/api/users/" + counselor.getUserId() + "/image")
                .points(counselor.getPoints())
                .counselorProfileInfoDto(CounselorProfileInfoDto.of(counselor.getCounselorProfile()))
                .build();
    }
}
