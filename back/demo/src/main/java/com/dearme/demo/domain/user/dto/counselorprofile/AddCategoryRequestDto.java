package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Category;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddCategoryRequestDto {
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;

    public Category toEntity(){
        return Category.builder().contents(this.contents).build();
    }
}
