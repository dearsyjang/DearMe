package com.dearme.demo.domain.counseling.service;

import com.dearme.demo.domain.counseling.dto.CounselingInfoListResponseDto;
import com.dearme.demo.domain.counseling.dto.CounselingInfoResponseDto;
import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.repository.CounselingRepository;
import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CounselingServiceImpl implements CounselingService{
    private final CounselingRepository counselingRepository;

    @Override
    public void createCounseling(CounselingDocument counselingDocument) {
        Counseling counseling = counselingDocument.toCounselingEntity();
        counseling.setCounselingDocument(counselingDocument);
        counselingRepository.save(counseling);
    }

    public CounselingInfoListResponseDto getCounselings(String id) {
        List<Counseling> counselings = counselingRepository.findAllByCounselor_Id(id);
        List<CounselingInfoResponseDto> counselingInfoResponseDtos = new ArrayList<>();
        for(Counseling counseling : counselings){
            counselingInfoResponseDtos.add(CounselingInfoResponseDto.of(counseling));
        }
        return new CounselingInfoListResponseDto(counselingInfoResponseDtos);
    }
}
