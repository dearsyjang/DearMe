package com.dearme.demo.domain.review.service;

import com.dearme.demo.domain.favorite.dto.FavoriteSaveResponseDto;
import com.dearme.demo.domain.review.dto.ReviewCounselorViewResponseDto;
import com.dearme.demo.domain.review.dto.ReviewSaveRequestDto;
import com.dearme.demo.domain.review.dto.ReviewSaveResponseDto;
import com.dearme.demo.domain.review.entity.Favorite;
import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.review.exception.NoExistReviewException;
import com.dearme.demo.domain.review.exception.NoReviewDeletePermissionException;
import com.dearme.demo.domain.review.exception.NoReviewSavePermissionException;
import com.dearme.demo.domain.review.repository.ReviewRepository;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistCounselorException;
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
        if(user.getType().equals(Type.COUNSELOR)){
            throw new NoReviewSavePermissionException();
        }
        review.setUser(user);
        User counselor = userRepository.findUserById(dto.getId()).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        counselor.getCounselorProfile().updateReviewValue(review.getValue(), 1);
        review.setCounselor(counselor);
        reviewRepository.save(review);
        return new ReviewSaveResponseDto(review.getId());
    }
    @Override
    @Transactional
    public void reviewDelete(String id, Long reviewId) {
        Review review = reviewRepository.findReviewByReviewid(reviewId).orElseThrow(()->{
            throw new NoExistReviewException();
        });
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getId().equals(review.getUser().getId())){

            User counselor = userRepository.findUserById(review.getCounselor().getId()).orElseThrow(() -> {
                throw new NoExistUserException();
            });
            counselor.getCounselorProfile().updateReviewValue(-1 * review.getValue(), -1);
            reviewRepository.delete(review);
        }else{
            throw new NoReviewDeletePermissionException();
        }
    }

    @Override
    public List<ReviewCounselorViewResponseDto> reviewCounselorView(String id) {
        List<Review> tempList = reviewRepository.findReviewByCounselor_Id(id);
        if(tempList.isEmpty()) throw new NoExistReviewException();

        List<ReviewCounselorViewResponseDto> reviewList = new ArrayList<>();
        for(Review r : tempList){
            reviewList.add(new ReviewCounselorViewResponseDto(r.getId(),
                    r.getUser().getNickName(),
                    r.getValue(),
                    r.getContents()));
        }
        return reviewList;
    }
}
