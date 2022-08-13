package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Career;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCareerRequestDto {
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;

    public Career toEntity(){
        return Career.builder().contents(this.contents).build();
    }
}
