package com.dearme.demo.domain.favorite.service;

import com.dearme.demo.domain.favorite.dto.FavoriteSaveRequestDto;
import com.dearme.demo.domain.favorite.dto.FavoriteSaveResponseDto;
import com.dearme.demo.domain.favorite.dto.FavoriteViewResponseDto;
import com.dearme.demo.domain.favorite.entity.Favorite;
import com.dearme.demo.domain.favorite.exception.NoExistFavoriteException;
import com.dearme.demo.domain.favorite.exception.NoFavoriteDeletePermissionException;
import com.dearme.demo.domain.favorite.exception.NoFavoriteSaveCounselorPermissionException;
import com.dearme.demo.domain.favorite.exception.NoFavoriteSavePermissionException;
import com.dearme.demo.domain.favorite.repository.FavoriteRepository;
import com.dearme.demo.domain.favorite.entity.Favorite;
import com.dearme.demo.domain.group.exception.GroupDeleteException;
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
        User counselor = userRepository.findById(dto.getId()).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        if(counselor.getType().equals(Type.USER)){
            throw new NoFavoriteSaveCounselorPermissionException();
        }
        favorite.setUser(user);
        favorite.setCounselor(counselor);

        favoriteRepository.save(favorite);
        return new FavoriteSaveResponseDto(favorite.getId());

    }

    @Override
    public List<FavoriteViewResponseDto> favoriteView(String id) {

        List<Favorite> tempList = favoriteRepository.findFavoriteByUser_Id(id);
        List<FavoriteViewResponseDto> favoriteList = new ArrayList<>();
        for(Favorite f : tempList){
            favoriteList.add(FavoriteViewResponseDto.of(f));
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

        if(user.getUserId().equals(favorite.getCounselor().getUserId())){
            favoriteRepository.delete(favorite);
        }else{
            throw new NoFavoriteDeletePermissionException();
        }
    }
}
