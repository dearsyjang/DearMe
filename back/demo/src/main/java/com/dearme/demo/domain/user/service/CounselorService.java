package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.counselorsearch.CounselorSearchRequestDto;
import com.dearme.demo.domain.user.dto.counselorsearch.CounselorViewResponseDto;
import com.dearme.demo.domain.user.dto.counselorsearch.CounselorsViewResponseDto;

import java.util.List;

public interface CounselorService {
    List<CounselorsViewResponseDto> getCounselors(String id, CounselorSearchRequestDto dto);
    CounselorViewResponseDto getCounselor(Long id);
}
