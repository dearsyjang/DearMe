package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Career;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCareerRequestDto {
    private String contents;

    public Career toEntity(){
        return Career.builder().contents(this.contents).build();
    }
}
