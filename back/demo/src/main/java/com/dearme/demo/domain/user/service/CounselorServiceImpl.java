package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.favorite.entity.Favorite;
import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.review.repository.ReviewRepository;
import com.dearme.demo.domain.user.dto.etc.ReviewViewResponseDto;
import com.dearme.demo.domain.user.dto.counselorsearch.CounselorSearchRequestDto;
import com.dearme.demo.domain.user.dto.counselorsearch.CounselorViewResponseDto;
import com.dearme.demo.domain.user.dto.counselorsearch.CounselorsViewResponseDto;
import com.dearme.demo.domain.user.entity.Category;
import com.dearme.demo.domain.user.exception.NoExistCounselorException;
import com.dearme.demo.global.qtype.QUser;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.querydsl.core.types.OrderSpecifier;
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
        User user1 = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<User> userList = queryFactory.selectFrom(user)
                .where(user.type.eq(Type.COUNSELOR)
                .and(user.counselorProfile.price.between(dto.getDownPrice(), dto.getUpPrice())))
                .orderBy(order(dto))
                .fetch();

        List<User> userList2 = new ArrayList<>();

        if(!dto.getCategory().equals("")){
            for(User u : userList){
                for(Category category : u.getCounselorProfile().getCategories()){
                    if(category.getContents().equals(dto.getCategory()))
                        userList2.add(u);
                }
            }
        }else{
            userList2=userList;
        }
        List<CounselorsViewResponseDto> counselorsViewResponseDtos = new ArrayList<>();
        if(dto.getFavorite()){
            for(Favorite favorite : user1.getFavorites()){
                for(User u: userList2){
                    if(u.getId()==favorite.getCounselor().getId())
                        counselorsViewResponseDtos.add(CounselorsViewResponseDto.of(u, ReviewCalc(u)));
                }
            }
        }else{
            for(User u: userList2){
                counselorsViewResponseDtos.add(CounselorsViewResponseDto.of(u, ReviewCalc(u)));
            }
        }


        return counselorsViewResponseDtos;

    }

    @Override
    public CounselorViewResponseDto getCounselor(Long id) {
        User user = userRepository.findUserByUserId(id).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        double value=ReviewCalc(user);

        List<Review> tempList = reviewRepository.findReviewsByCounselor_UserId(id);
        List<ReviewViewResponseDto> reviewList = new ArrayList<>();
        for(Review r : tempList){
            reviewList.add(ReviewViewResponseDto.of(r, r.getUser()));
        }
        return CounselorViewResponseDto.of(user, value, reviewList);
    }

    public double ReviewCalc(User user){
        double value=0f;
        if(user.getCounselorProfile().getReviewcnt()>=1f) value=Math.round((user.getCounselorProfile().getReviewvalue()/ user.getCounselorProfile().getReviewcnt())*100)/100.0;
        return value;
    }
    public OrderSpecifier order(CounselorSearchRequestDto dto){
         if(dto.getReviewCntUp()){
            return user.counselorProfile.reviewcnt.asc();
        }else if(dto.getReviewCntDown()){
            return user.counselorProfile.reviewcnt.desc();
        }else if(dto.getReviewScoreUp()){
            return user.counselorProfile.reviewvalue.asc();
        }else if(dto.getReviewScoreDown()){
            return user.counselorProfile.reviewvalue.desc();
        }else{
            return user.nickName.asc();
        }
    }

}

