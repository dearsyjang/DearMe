package com.dearme.demo.domain.user.dto.counselorsearch;

import com.dearme.demo.domain.user.dto.counselorprofile.CategoryInfoDto;
import com.dearme.demo.domain.user.entity.Category;
import com.dearme.demo.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CounselorsViewResponseDto {
    private Long counselorId;

    private String nickName;

    private String pictureUrl;

    private Double value;

    private Long price;

    private Long reviewCnt;

    private List<CategoryInfoDto> categories;

    public static CounselorsViewResponseDto of(User counselor, Double value){
        return CounselorsViewResponseDto.builder().
                counselorId(counselor.getUserId())
                .nickName(counselor.getNickName())
                .pictureUrl(counselor.getPicture().getFileName())
                .price(counselor.getCounselorProfile().getPrice())
                .reviewCnt(counselor.getCounselorProfile().getReviewCnt())
                .categories(toCategoryInfoDto(counselor.getCounselorProfile().getCategories()))
                .value(value)
                .build();
    }

    private static List<CategoryInfoDto> toCategoryInfoDto(List<Category> categories){
        List<CategoryInfoDto> result = new ArrayList<>();
        for(Category category : categories){
            result.add(CategoryInfoDto.of(category));
        }
        return result;
    }
}
