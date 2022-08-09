package com.dearme.demo.domain.user.dto.counselor;

import com.dearme.demo.domain.user.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CounselorsViewResponseDto {
    private Long userid;

    private String nickName;

    private String pictureUrl;

    private double value;
    private Long reviewCnt;
    private List<Category> categories;

}
