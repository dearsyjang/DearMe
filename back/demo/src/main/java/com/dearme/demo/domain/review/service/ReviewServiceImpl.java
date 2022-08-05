package com.dearme.demo.domain.review.service;

import com.dearme.demo.domain.review.dto.ReviewCounselorViewResponseDto;
import com.dearme.demo.domain.review.dto.ReviewSaveRequestDto;
import com.dearme.demo.domain.review.dto.ReviewSaveResponseDto;
import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.review.exception.NoExistReviewException;
import com.dearme.demo.domain.review.exception.NoReviewDeletePermissionException;
import com.dearme.demo.domain.review.repository.ReviewRepository;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    @Override
    @Transactional
    public ReviewSaveResponseDto reviewSave(String id, ReviewSaveRequestDto dto) {
        Review review;
        review=dto.toReviewEntity();
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        review.setUser(user);
        reviewRepository.save(review);
        return new ReviewSaveResponseDto(review.getReviewid());
    }

    @Transactional
    public void reviewDelete(String id, Long reviewid) {
        Review review = reviewRepository.findReviewByReviewid(reviewid).orElseThrow(()->{
            throw new NoExistReviewException();
        });
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getUserId().equals(review.getUser().getUserId())){
            reviewRepository.delete(review);
        }else{
            throw new NoReviewDeletePermissionException();
        }
    }

    @Override
    public List<ReviewCounselorViewResponseDto> reviewCounselorView(String id) {
        List<Review> tempList = reviewRepository.findReviewByCounselorid(id);
        System.out.println(tempList.toArray());
        System.out.println(tempList.toString());
        List<ReviewCounselorViewResponseDto> reviewList = new ArrayList<>();
        for(Review r : tempList){
            reviewList.add(new ReviewCounselorViewResponseDto(r.getUser().getNickName(),
                    r.getValue(),
                    r.getContents()));
        }
        return reviewList;
    }
}
