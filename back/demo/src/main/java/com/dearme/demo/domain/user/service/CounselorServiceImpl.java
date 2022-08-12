package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.review.exception.NoExistReviewException;
import com.dearme.demo.domain.review.repository.ReviewRepository;
import com.dearme.demo.domain.user.dto.ReviewViewResponseDto;
import com.dearme.demo.domain.user.dto.counselor.CounselorSearchRequestDto;
import com.dearme.demo.domain.user.dto.counselor.CounselorViewResponseDto;
import com.dearme.demo.domain.user.dto.counselor.CounselorsViewResponseDto;
import com.dearme.demo.domain.user.entity.QUser;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CounselorServiceImpl implements CounselorService{
    private final UserRepository userRepository;

    private  final ReviewRepository reviewRepository;

    QUser user = QUser.user;
    @Autowired
    EntityManager entityManager;

    @Override
    public List<CounselorsViewResponseDto> getCounselors(String id, CounselorSearchRequestDto dto) {

//        List<User> userList = userRepository.findUserByTypeEquals(Type.COUNSELOR);
//
//        List<CounselorsViewResponseDto> counselorsViewResponseDtos = new ArrayList<>();
//        for(User u: userList){
//            counselorsViewResponseDtos.add(CounselorsViewResponseDto.of(u, ReviewCalc(u)));
//        }
//        return counselorsViewResponseDtos;

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<User> userList = queryFactory.selectFrom(user)
                .where(user.type.eq(Type.COUNSELOR)
                .and(user.counselorProfile.price.between(dto.getDownPrice(), dto.getUpPrice())))
                .orderBy(dto.getReviewCntUp() ? user.counselorProfile.reviewcnt.asc(): user.nickName.asc())
                .orderBy(dto.getReviewCntDown() ? user.counselorProfile.reviewcnt.desc(): user.nickName.asc())
                .fetch();

        for(User user : userList){
            System.out.println(user.getNickName());
        }
        return null;

    }

    @Override
    public CounselorViewResponseDto getCounselor(Long id) {
        User user = userRepository.findUserByUserId(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        double value=ReviewCalc(user);

        List<Review> tempList = reviewRepository.findReviewsByCounselor_UserId(id);
        List<ReviewViewResponseDto> reviewList = new ArrayList<>();
        for(Review r : tempList){
            reviewList.add(new ReviewViewResponseDto(r.getId(),
                    r.getUser().getNickName(),
                    r.getValue(),
                    r.getContents()));
        }
        return CounselorViewResponseDto.of(user, value, reviewList);
    }

    public double ReviewCalc(User user){
        double value=0f;
        if(user.getCounselorProfile().getReviewcnt()>=1f) value=Math.round((user.getCounselorProfile().getReviewvalue()/ user.getCounselorProfile().getReviewcnt())*100)/100.0;
        return value;
    }
}

