package com.dearme.demo.domain.favorite.service;

import com.dearme.demo.domain.favorite.dto.FavoriteSaveRequestDto;
import com.dearme.demo.domain.favorite.dto.FavoriteSaveResponseDto;
import com.dearme.demo.domain.favorite.dto.FavoriteViewResponseDto;

import java.util.List;

public interface FavoriteService {
    FavoriteSaveResponseDto favoriteSave(String id, FavoriteSaveRequestDto dto);
    List<FavoriteViewResponseDto> favoriteView(String id);

    void favoriteDelete(String id, Long favoriteId);

}
