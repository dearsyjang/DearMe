package com.dearme.demo.domain.counseling.dto;

import com.dearme.demo.domain.counseling.entity.Status;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class UpdateCounselingRequestDto {
    @NotNull(message = "id는 비워둘 수 없습니다.")
    private Long id;

    @NotBlank(message = "status는 비워둘 수 없습니다.")
    private Status status;
}
