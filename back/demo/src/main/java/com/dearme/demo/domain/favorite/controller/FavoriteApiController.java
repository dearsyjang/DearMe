package com.dearme.demo.domain.favorite.controller;


import com.dearme.demo.domain.favorite.dto.FavoriteSaveRequestDto;
import com.dearme.demo.domain.favorite.service.FavoriteService;
import com.dearme.demo.domain.review.dto.ReviewSaveRequestDto;
import com.dearme.demo.domain.review.entity.Favorite;
import com.dearme.demo.domain.review.service.ReviewService;
import com.dearme.demo.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping("/favorites")
@RestController
public class FavoriteApiController {
    private final FavoriteService favoriteService;

    @Operation(summary = "favorite Save Test", description = "즐겨찾기 저장")
    @PostMapping
    public ResponseEntity<CommonResponse> favoriteSave(HttpServletRequest request, @RequestBody @Validated FavoriteSaveRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(favoriteService.favoriteSave(id, dto)), HttpStatus.OK);
    }

    @Operation(summary = "favorite View Test", description = "즐겨찾기 조회")
    @GetMapping
    public ResponseEntity<CommonResponse> favoriteView(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(favoriteService.favoriteView(id)), HttpStatus.OK);
    }

    @Operation(summary = "favorite Delete Test", description = "즐겨찾기 삭제")
    @DeleteMapping("/{favoriteid}")
    public ResponseEntity<CommonResponse> favoriteDelete(HttpServletRequest request, @PathVariable("favoriteid") Long favoriteid){
        String id = (String) request.getAttribute("id");
        favoriteService.favoriteDelete(id, favoriteid);
        return null;
    }

}
