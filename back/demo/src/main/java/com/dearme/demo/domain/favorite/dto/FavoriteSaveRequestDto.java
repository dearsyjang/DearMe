package com.dearme.demo.domain.favorite.dto;

import com.dearme.demo.domain.review.entity.Favorite;
import com.dearme.demo.domain.review.entity.Review;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FavoriteSaveRequestDto {
    @NotBlank
    private String id;

}
