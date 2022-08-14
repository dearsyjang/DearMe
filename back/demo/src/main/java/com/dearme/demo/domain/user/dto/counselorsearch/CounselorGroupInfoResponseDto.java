package com.dearme.demo.domain.user.dto.counselorsearch;

import com.dearme.demo.domain.group.entity.Group;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CounselorGroupInfoResponseDto {
    private Long id;
    private String title;

    public static CounselorGroupInfoResponseDto of(Group entity){
        return CounselorGroupInfoResponseDto.builder().id(entity.getId()).title(entity.getTitle()).build();
    }
}
