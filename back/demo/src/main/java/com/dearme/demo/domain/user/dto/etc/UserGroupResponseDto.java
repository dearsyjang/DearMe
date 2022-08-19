package com.dearme.demo.domain.user.dto.etc;

import com.dearme.demo.domain.group.entity.Group;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserGroupResponseDto {
    private Long id;
    private String title;

    public static UserGroupResponseDto of(Group entity){
        return UserGroupResponseDto.builder().id(entity.getId()).title(entity.getTitle()).build();
    }
}
