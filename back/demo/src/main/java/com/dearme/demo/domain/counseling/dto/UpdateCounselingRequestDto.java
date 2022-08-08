package com.dearme.demo.domain.counseling.dto;

import com.dearme.demo.domain.counseling.entity.Status;
import lombok.Getter;

@Getter
public class UpdateCounselingRequestDto {
    private Long id;
    private Status status;
}
