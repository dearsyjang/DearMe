package com.dearme.demo.domain.user.dto;

import com.dearme.demo.domain.user.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryInfoDto {
    private Long id;
    private String contents;

    public static CategoryInfoDto of(Category entity){
        return CategoryInfoDto.builder().id(entity.getId()).contents(entity.getContents()).build();
    }
}
