package com.dearme.demo.domain.user.dto.counselor;

import com.dearme.demo.domain.user.dto.ReviewViewResponseDto;
import com.dearme.demo.domain.user.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CounselorViewResponseDto {
    private Long userid;

    private String nickName;

    private String pictureUrl;

    private double value;

    private Long reviewCnt;

    private Long price;

    private String introduce;

    private List<Document> document;

    private List<Career> careers;

    private List<Certificate> certificates;

    private List<Category> categories;
    private List<ReviewViewResponseDto> reviews;

}
