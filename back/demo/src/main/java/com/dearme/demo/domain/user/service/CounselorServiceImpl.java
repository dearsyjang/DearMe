package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.board.dto.board.BoardViewResponseDto;
import com.dearme.demo.domain.board.dto.comment.CommentResponseDto;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.user.dto.counselor.CounselorsViewResponseDto;
import com.dearme.demo.domain.user.dto.user.UserInfoResponseDto;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
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
            double value=0f;
            if(u.getCounselorProfile().getReviewcnt()>=1f) value=Math.round((u.getCounselorProfile().getReviewvalue()/ u.getCounselorProfile().getReviewcnt())*100)/100.0;
            counselorsViewResponseDto.add(new CounselorsViewResponseDto(u.getUserId(),
                    u.getNickName(),
                    u.getPicture().getRealFileName(),
                    value,
                    u.getCounselorProfile().getReviewcnt()));
        }

        return counselorsViewResponseDto;
    }
}
