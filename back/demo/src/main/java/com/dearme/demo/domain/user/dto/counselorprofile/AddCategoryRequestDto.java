package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Category;
import lombok.Data;

@Data
public class AddCategoryRequestDto {
    private String contents;

    public Category toEntity(){
        return Category.builder().contents(this.contents).build();
    }
}
