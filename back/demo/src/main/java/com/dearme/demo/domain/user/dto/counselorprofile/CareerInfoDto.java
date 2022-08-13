package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Career;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CareerInfoDto {
    private Long id;
    private String contents;

    public static CareerInfoDto of(Career entity){
        return CareerInfoDto.builder().id(entity.getId()).contents(entity.getContents()).build();
    }
}
