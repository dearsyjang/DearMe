package com.dearme.demo.domain.favorite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavoriteViewResponseDto {
    private Long favoriteid;
    private String nickname;
}
