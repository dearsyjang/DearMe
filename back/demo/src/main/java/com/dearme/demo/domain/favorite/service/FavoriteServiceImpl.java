package com.dearme.demo.domain.favorite.service;

import com.dearme.demo.domain.favorite.dto.FavoriteSaveRequestDto;
import com.dearme.demo.domain.favorite.dto.FavoriteSaveResponseDto;
import com.dearme.demo.domain.favorite.dto.FavoriteViewResponseDto;
import com.dearme.demo.domain.favorite.exception.NoExistFavoriteException;
import com.dearme.demo.domain.favorite.exception.NoFavoriteDeletePermissionException;
import com.dearme.demo.domain.favorite.exception.NoFavoriteSavePermissionException;
import com.dearme.demo.domain.favorite.repository.FavoriteRepository;
import com.dearme.demo.domain.review.dto.ReviewCounselorViewResponseDto;
import com.dearme.demo.domain.review.dto.ReviewSaveRequestDto;
import com.dearme.demo.domain.review.dto.ReviewSaveResponseDto;
import com.dearme.demo.domain.review.entity.Favorite;
import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.review.exception.NoExistReviewException;
import com.dearme.demo.domain.review.exception.NoReviewDeletePermissionException;
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
public class FavoriteServiceImpl implements FavoriteService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    private final FavoriteRepository favoriteRepository;


    @Override
    @Transactional
    public FavoriteSaveResponseDto favoriteSave(String id, FavoriteSaveRequestDto dto) {
        Favorite favorite = new Favorite();
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getType().equals(Type.COUNSELOR)){
            throw new NoFavoriteSavePermissionException();
        }
        favorite.setUser(user);
        User counselor = userRepository.findUserById(dto.getId()).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        favorite.setCounselor(counselor);

        favoriteRepository.save(favorite);
        return new FavoriteSaveResponseDto(favorite.getId());

    }

    @Override
    public List<FavoriteViewResponseDto> favoriteView(String id) {

        List<Favorite> tempList = favoriteRepository.findFavoriteByUser_Id(id);
        List<FavoriteViewResponseDto> favoriteList = new ArrayList<>();
        for(Favorite f : tempList){
            favoriteList.add(new FavoriteViewResponseDto(f.getId(),
                    f.getCounselor().getNickName()));
        }
        return favoriteList;
    }

    @Override
    @Transactional
    public void favoriteDelete(String id, Long favoriteId) {
        Favorite favorite = favoriteRepository.findFavoriteById(favoriteId).orElseThrow(() -> {
            throw new NoExistFavoriteException();
        });

        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getId().equals(favorite.getUser().getId())){
            favoriteRepository.delete(favorite);
        }else{
            throw new NoFavoriteDeletePermissionException();
        }
    }
}
