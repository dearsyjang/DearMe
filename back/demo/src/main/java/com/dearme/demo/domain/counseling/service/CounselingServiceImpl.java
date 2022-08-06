package com.dearme.demo.domain.counseling.service;

import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.repository.CounselingRepository;
import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounselingServiceImpl implements CounselingService{
    private final CounselingRepository counselingRepository;

    @Override
    public void createCounseling(CounselingDocument counselingDocument) {
        Counseling counseling = counselingDocument.toCounselingEntity();
        counselingRepository.save(counseling);
    }
}
