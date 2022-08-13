package com.dearme.demo.domain.user.dto.user;

import com.dearme.demo.domain.user.dto.counselorprofile.UpdateCounselorProfileDto;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class UpdateUserRequestDto {
    @NotBlank(message = "pw는 비워둘 수 없습니다.")
    private String pw;
    @NotBlank(message = "nickName은 비워둘 수 없습니다.")
    private String nickName;
    UpdateCounselorProfileDto counselorProfile;
}
