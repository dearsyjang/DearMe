package com.dearme.demo.domain.user.dto.etc;

import com.dearme.demo.domain.group.entity.Group;
import com.dearme.demo.domain.review.entity.Review;
import com.dearme.demo.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewViewResponseDto {
    private Long id;
    private String nickName;
    private Long value;
    private String contents;

    public static ReviewViewResponseDto of(Review entity, User u){
        return ReviewViewResponseDto.builder()
                .id(entity.getId())
                .nickName(u.getNickName())
                .value(entity.getValue())
                .contents(entity.getContents())
                .build();
    }
}