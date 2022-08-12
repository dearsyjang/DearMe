package com.dearme.demo.domain.user.dto.counselor;

import com.dearme.demo.domain.user.dto.etc.ReviewViewResponseDto;
import com.dearme.demo.domain.user.dto.user.CareerInfoDto;
import com.dearme.demo.domain.user.dto.user.CategoryInfoDto;
import com.dearme.demo.domain.user.dto.user.CertificateInfoDto;
import com.dearme.demo.domain.user.dto.user.DocumentInfoDto;
import com.dearme.demo.domain.user.entity.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CounselorViewResponseDto {
    private Long userId;

    private String nickName;

    private String pictureUrl;

    private Double value;

    private Long reviewCnt;

    private Long price;

    private String introduce;

    private List<DocumentInfoDto> document;

    private List<CareerInfoDto> careers;

    private List<CertificateInfoDto> certificates;

    private List<CategoryInfoDto> categories;
    private List<ReviewViewResponseDto> reviews;

    public static CounselorViewResponseDto of(User entity, Double value, List<ReviewViewResponseDto> reviews){
        return CounselorViewResponseDto.builder()
                .userId(entity.getUserId())
                .nickName(entity.getNickName())
                .pictureUrl(entity.getPicture().getRealFileName())
                .value(value)
                .reviewCnt(entity.getCounselorProfile().getReviewcnt())
                .price(entity.getCounselorProfile().getPrice())
                .introduce(entity.getCounselorProfile().getIntroduce())
                .document(toDocumentInfoDto(entity.getCounselorProfile().getDocuments()))
                .careers(toCareerInfoDto(entity.getCounselorProfile().getCareers()))
                .certificates(toCertificationInfoDto(entity.getCounselorProfile().getCertificates()))
                .categories(toCategoryInfoDto(entity.getCounselorProfile().getCategories()))
                .reviews(reviews)
                .build();
    }
    private static List<DocumentInfoDto> toDocumentInfoDto(List<Document> documents){
        List<DocumentInfoDto> result = new ArrayList<>();
        for(Document document : documents){
            result.add(DocumentInfoDto.of(document));
        }
        return result;
    }
    private static List<CareerInfoDto> toCareerInfoDto(List<Career> careers){
        List<CareerInfoDto> result = new ArrayList<>();
        for(Career career : careers){
            result.add(CareerInfoDto.of(career));
        }
        return result;
    }
    private static List<CategoryInfoDto> toCategoryInfoDto(List<Category> categories){
        List<CategoryInfoDto> result = new ArrayList<>();
        for(Category category : categories){
            result.add(CategoryInfoDto.of(category));
        }
        return result;
    }
    private static List<CertificateInfoDto> toCertificationInfoDto(List<Certificate> certificates){
        List<CertificateInfoDto> result = new ArrayList<>();
        for(Certificate certificate : certificates){
            result.add(CertificateInfoDto.of(certificate));
        }
        return result;
    }
}
