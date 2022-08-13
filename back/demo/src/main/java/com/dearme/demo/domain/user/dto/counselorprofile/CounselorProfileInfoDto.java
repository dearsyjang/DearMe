package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Career;
import com.dearme.demo.domain.user.entity.Category;
import com.dearme.demo.domain.user.entity.Certificate;
import com.dearme.demo.domain.user.entity.CounselorProfile;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CounselorProfileInfoDto {
    private double value;
    private Long price;
    private String introduce;

    List<CareerInfoDto> careers;
    List<CategoryInfoDto> categories;
    List<CertificateInfoDto> certificates;

    public static CounselorProfileInfoDto of(CounselorProfile entity){
        double value=0f;
        if(entity.getReviewcnt()>=1f) value=Math.round((entity.getReviewvalue()/ entity.getReviewcnt())*100)/100.0;
        return CounselorProfileInfoDto.builder()
                .introduce(entity.getIntroduce())
                .price(entity.getPrice())
                .value(value)
                .careers(toCareersInfoDto(entity.getCareers()))
                .certificates(toCertificateInfoDto(entity.getCertificates()))
                .categories(toCategoryInfoDto(entity.getCategories()))
                .build();
    }

    private static List<CareerInfoDto> toCareersInfoDto(List<Career> careers){
        List<CareerInfoDto> result = new ArrayList<>();
        for(Career career : careers){
            result.add(CareerInfoDto.of(career));
        }
        return result;
    }

    private static List<CertificateInfoDto> toCertificateInfoDto(List<Certificate> certificates){
        List<CertificateInfoDto> result = new ArrayList<>();
        for(Certificate certificate : certificates){
            result.add(CertificateInfoDto.of(certificate));
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
}
