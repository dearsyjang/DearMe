package com.dearme.demo.domain.counseling.service;

import com.dearme.demo.domain.counseling.dto.CounselingInfoListResponseDto;
import com.dearme.demo.domain.counseling.dto.CounselingInfoResponseDto;
import com.dearme.demo.domain.counseling.dto.UpdateCounselingRequestDto;
import com.dearme.demo.domain.counseling.dto.UpdateCounselingResponseDto;
import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.entity.Status;
import com.dearme.demo.domain.counseling.exception.NoExistCounselingException;
import com.dearme.demo.domain.counseling.repository.CounselingRepository;
import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CounselingServiceImpl implements CounselingService{
    private final CounselingRepository counselingRepository;

    private final UserRepository userRepository;

    @Override
    public void createCounseling(CounselingDocument counselingDocument) {
        Counseling counseling = counselingDocument.toCounselingEntity();
        counseling.setCounselingDocument(counselingDocument);
        counselingRepository.save(counseling);
    }

    @Override
    public CounselingInfoListResponseDto getCounselings(String id) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        List<Counseling> counselings = null;
        if(user.getType().equals(Type.USER))
            counselings = counselingRepository.findAllByUser_Id(id);
        else
            counselings = counselingRepository.findAllByCounselor_Id(id);
        List<CounselingInfoResponseDto> counselingInfoResponseDtos = new ArrayList<>();
        for(Counseling counseling : counselings){
            counselingInfoResponseDtos.add(CounselingInfoResponseDto.of(counseling));
        }
        return new CounselingInfoListResponseDto(counselingInfoResponseDtos);
    }

    @Override
    public void createGroupCounseling(CounselingDocument counselingDocument) {
        Counseling counseling = counselingDocument.toGroupCounselingEntity();
        counseling.setCounselingDocument(counselingDocument);
        counselingRepository.save(counseling);
    }

    @Override
    public UpdateCounselingResponseDto updateCounseling(String id, UpdateCounselingRequestDto dto) {
        Counseling target = counselingRepository.findCounselingByCounselor_IdAndId(id, dto.getId()).orElseThrow(() -> {
            throw new NoExistCounselingException();
        });
        if(dto.getStatus().equals(Status.REJECT)){
            counselingRepository.delete(target);
        }else {
            target.updateCounseling(dto.getStatus());
            counselingRepository.save(target);
        }
        return null;
    }
}
