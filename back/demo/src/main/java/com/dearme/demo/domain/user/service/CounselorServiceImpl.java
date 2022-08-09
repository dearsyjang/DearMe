package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.counselor.CounselorViewResponseDto;
import com.dearme.demo.domain.user.dto.counselor.CounselorsViewResponseDto;
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
public class CounselorServiceImpl implements CounselorService{
    private final UserRepository userRepository;
    @Override
    public List<CounselorsViewResponseDto> getCounselors(String id) {
        List<User> userList = userRepository.findUserByTypeEquals(Type.COUNSELOR);

        List<CounselorsViewResponseDto> counselorsViewResponseDto = new ArrayList<>();
        for(User u: userList){
            double value=ReviewCalc(u);
            counselorsViewResponseDto.add(new CounselorsViewResponseDto(u.getUserId(),
                    u.getNickName(),
                    u.getPicture().getRealFileName(),
                    value,
                    u.getCounselorProfile().getReviewcnt(),
                    u.getCounselorProfile().getCategories()));
        }

        return counselorsViewResponseDto;
    }

    @Override
    public CounselorViewResponseDto getCounselor(String id) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        double value=ReviewCalc(user);
        return new CounselorViewResponseDto(user.getUserId(),
                user.getNickName(),
                user.getPicture().getRealFileName(),
                value,
                user.getCounselorProfile().getReviewcnt(),
                user.getCounselorProfile().getPrice(),
                user.getCounselorProfile().getIntroduce(),
                user.getCounselorProfile().getDocuments(),
                user.getCounselorProfile().getCareers(),
                user.getCounselorProfile().getCertificates(),
                user.getCounselorProfile().getCategories());
    }
    public double ReviewCalc(User user){
        double value=0f;
        if(user.getCounselorProfile().getReviewcnt()>=1f) value=Math.round((user.getCounselorProfile().getReviewvalue()/ user.getCounselorProfile().getReviewcnt())*100)/100.0;
        return value;
    }
}
