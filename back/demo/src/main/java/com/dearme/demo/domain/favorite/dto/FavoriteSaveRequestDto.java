package com.dearme.demo.domain.favorite.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FavoriteSaveRequestDto {
    @NotNull(message = "id는 비워둘 수 없습니다.")
    private Long id;

}
