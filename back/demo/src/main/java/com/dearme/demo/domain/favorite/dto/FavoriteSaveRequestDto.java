package com.dearme.demo.domain.favorite.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FavoriteSaveRequestDto {
    @NotBlank
    private String counselorid;

}
