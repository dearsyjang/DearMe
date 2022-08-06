package com.dearme.demo.domain.favorite.service;

import com.dearme.demo.domain.favorite.dto.FavoriteSaveRequestDto;
import com.dearme.demo.domain.favorite.dto.FavoriteSaveResponseDto;
import com.dearme.demo.domain.favorite.dto.FavoriteViewResponseDto;
import com.dearme.demo.domain.favorite.entity.Favorite;
import com.dearme.demo.domain.favorite.exception.NoExistFavoriteException;
import com.dearme.demo.domain.favorite.exception.NoFavoriteDeletePermissionException;
import com.dearme.demo.domain.favorite.repository.FavoriteRepository;
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
        favorite.setUser(user);
        User counselor = userRepository.findUserById(dto.getCounselorid()).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        favorite.setCounselor(counselor);

        favoriteRepository.save(favorite);
        return new FavoriteSaveResponseDto(favorite.getFavoriteid());

    }

    @Override
    public List<FavoriteViewResponseDto> favoriteView(String id) {

        List<Favorite> tempList = favoriteRepository.findFavoriteByUser_Id(id);
        List<FavoriteViewResponseDto> favoriteList = new ArrayList<>();
        for(Favorite f : tempList){
            favoriteList.add(new FavoriteViewResponseDto(f.getFavoriteid(),
                    f.getCounselor().getNickName()));
        }
        return favoriteList;
    }

    @Override
    @Transactional
    public void favoriteDelete(String id, Long favoriteid) {
        Favorite favorite = favoriteRepository.findFavoriteByFavoriteid(favoriteid).orElseThrow(() -> {
            throw new NoExistFavoriteException();
        });

        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getUserId().equals(favorite.getUser().getUserId())){
            favoriteRepository.delete(favorite);
        }else{
            throw new NoFavoriteDeletePermissionException();
        }
    }
}
