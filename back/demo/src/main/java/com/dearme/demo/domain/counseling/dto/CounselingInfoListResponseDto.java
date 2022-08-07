package com.dearme.demo.domain.counseling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CounselingInfoListResponseDto {
    List<CounselingInfoResponseDto> counselings;
}
