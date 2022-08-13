package com.dearme.demo.domain.favorite.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FavoriteSaveRequestDto {
    @NotBlank(message = "id는 비워둘 수 없습니다.")
    private Long id;

}
