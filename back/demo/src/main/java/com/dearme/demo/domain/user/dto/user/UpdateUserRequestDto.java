package com.dearme.demo.domain.user.dto.user;

import com.dearme.demo.domain.user.dto.counselorprofile.UpdateCounselorProfileDto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateUserRequestDto {
    private String pw;
    private String nickName;
    UpdateCounselorProfileDto counselorProfile;
}
