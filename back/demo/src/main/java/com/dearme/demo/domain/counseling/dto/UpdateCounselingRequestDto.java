package com.dearme.demo.domain.counseling.dto;

import com.dearme.demo.domain.counseling.entity.Type;
import lombok.Getter;

@Getter
public class UpdateCounselingRequestDto {
    private Long id;
    private Type type;
}
