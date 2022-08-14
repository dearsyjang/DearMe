package com.dearme.demo.domain.group.dto;

import com.dearme.demo.domain.group.entity.Group;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupInfoResponseDto {
    private Long id;
    private String nickName;
    private String title;
    private String contents;
    private Long price;
    private Long counselorId;
    private String counselor;

    public static GroupInfoResponseDto of(Group entity){
        return GroupInfoResponseDto.builder()
                .id(entity.getId())
                .nickName(entity.getCounselor().getNickName())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .price(entity.getPrice())
                .counselorId(entity.getCounselor().getUserId())
                .counselor(entity.getCounselor().getNickName())
                .build();
    }
}
