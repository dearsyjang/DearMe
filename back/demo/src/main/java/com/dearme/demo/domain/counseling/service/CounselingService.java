package com.dearme.demo.domain.counseling.service;

import com.dearme.demo.domain.counseling.dto.CounselingInfoListResponseDto;
import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;

public interface CounselingService {
    void createCounseling(CounselingDocument counselingDocument);
    CounselingInfoListResponseDto getCounselings(String id);
}
