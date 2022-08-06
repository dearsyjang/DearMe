package com.dearme.demo.domain.user.dto.user;

import com.dearme.demo.domain.user.entity.Career;
import lombok.Data;

@Data
public class SignUpCareerRequestDto {
    private String contents;
    public Career toEntity(){
        return Career.builder().contents(this.contents).build();
    }
}
