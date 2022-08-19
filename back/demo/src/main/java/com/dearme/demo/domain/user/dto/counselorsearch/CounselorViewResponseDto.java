package com.dearme.demo.domain.user.dto.counselorsearch;

import com.dearme.demo.domain.group.entity.Group;
import com.dearme.demo.domain.user.dto.etc.ReviewViewResponseDto;
import com.dearme.demo.domain.user.dto.counselorprofile.CareerInfoDto;
import com.dearme.demo.domain.user.dto.counselorprofile.CategoryInfoDto;
import com.dearme.demo.domain.user.dto.counselorprofile.CertificateInfoDto;
import com.dearme.demo.domain.user.dto.counselorprofile.DocumentInfoDto;
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
    private List<CounselorGroupInfoResponseDto> groups;

    public static CounselorViewResponseDto of(User entity, Double value, List<ReviewViewResponseDto> reviews){
        return CounselorViewResponseDto.builder()
                .userId(entity.getUserId())
                .nickName(entity.getNickName())
                .pictureUrl("https://i7d206.p.ssafy.io/api/users/" + entity.getUserId() + "/image")
                .value(value)
                .reviewCnt(entity.getCounselorProfile().getReviewCnt())
                .price(entity.getCounselorProfile().getPrice())
                .introduce(entity.getCounselorProfile().getIntroduce())
                .document(toDocumentInfoDto(entity.getCounselorProfile().getDocuments()))
                .careers(toCareerInfoDto(entity.getCounselorProfile().getCareers()))
                .certificates(toCertificationInfoDto(entity.getCounselorProfile().getCertificates()))
                .categories(toCategoryInfoDto(entity.getCounselorProfile().getCategories()))
                .groups(toCounselorGroupInfoResponseDto(entity.getGroups()))
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
    private static List<CounselorGroupInfoResponseDto> toCounselorGroupInfoResponseDto(List<Group> groups){
        List<CounselorGroupInfoResponseDto> result = new ArrayList<>();
        for(Group group : groups){
            result.add(CounselorGroupInfoResponseDto.of(group));
        }
        return result;
    }

}
