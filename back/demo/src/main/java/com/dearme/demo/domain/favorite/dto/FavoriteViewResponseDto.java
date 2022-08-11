package com.dearme.demo.domain.favorite.dto;

import com.dearme.demo.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavoriteViewResponseDto {
    private Long id;
    private Long counselorId;
    private String nickName;
}
