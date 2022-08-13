package com.dearme.demo.domain.counselingroom.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateCounselingRoomRequestDto {
    @NotBlank(message = "counselingId는 비워둘 수 없습니다.")
    private Long counselingId;
}
