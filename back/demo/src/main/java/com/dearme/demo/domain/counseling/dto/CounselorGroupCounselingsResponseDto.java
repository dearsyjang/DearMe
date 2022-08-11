package com.dearme.demo.domain.counseling.dto;

import com.dearme.demo.domain.group.entity.Group;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CounselorGroupCounselingsResponseDto {
    private Long groupId;
    private String title;

    public static CounselorGroupCounselingsResponseDto of(Group entity){
        return CounselorGroupCounselingsResponseDto.builder().groupId(entity.getId()).title(entity.getTitle()).build();
    }
}
