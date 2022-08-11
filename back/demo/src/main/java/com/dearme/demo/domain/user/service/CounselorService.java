package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.counselor.CounselorViewResponseDto;
import com.dearme.demo.domain.user.dto.counselor.CounselorsViewResponseDto;

import java.util.List;

public interface CounselorService {
    List<CounselorsViewResponseDto> getCounselors(String id);
    CounselorViewResponseDto getCounselor(Long id);
}
