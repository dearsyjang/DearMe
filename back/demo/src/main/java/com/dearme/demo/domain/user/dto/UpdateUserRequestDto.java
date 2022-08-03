package com.dearme.demo.domain.user.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateUserRequestDto {
    private String pw;
    private String nickName;
    UpdateCounselorProfileDto counselorProfile;
}
