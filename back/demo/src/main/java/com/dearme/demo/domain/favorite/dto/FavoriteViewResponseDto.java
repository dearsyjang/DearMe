package com.dearme.demo.domain.favorite.dto;

import com.dearme.demo.domain.counselingroom.dto.CreateCounselingRoomResponseDto;
import com.dearme.demo.domain.counselingroom.entity.CounselingRoom;
import com.dearme.demo.domain.favorite.entity.Favorite;
import com.dearme.demo.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FavoriteViewResponseDto {
    private Long id;
    private Long counselorId;
    private String nickName;

    public static FavoriteViewResponseDto of(Favorite favorite){
        return FavoriteViewResponseDto.builder()
                .id(favorite.getId())
                .counselorId(favorite.getCounselor().getUserId())
                .nickName(favorite.getCounselor().getNickName())
                .build();
    }
}
