package com.dearme.demo.domain.favorite.repository;

import com.dearme.demo.domain.review.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findFavoriteById(Long id);
    List<Favorite> findFavoriteByUser_Id(String id);
}
