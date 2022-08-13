package com.dearme.demo.domain.review.repository;

import com.dearme.demo.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findReviewById(Long reviewId);

    List<Review> findReviewsByCounselor_UserId(Long userId);


    void deleteReviewByCounselor_UserId(Long counselorId);
}
