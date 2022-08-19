package com.dearme.demo.domain.user.dto.etc;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PointsUpdateRequestDto {
    @NotBlank(message = "price는 비워둘 수 없습니다.")
    private String price;
}
