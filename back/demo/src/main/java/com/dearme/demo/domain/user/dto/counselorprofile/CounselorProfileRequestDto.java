package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Career;
import com.dearme.demo.domain.user.entity.Category;
import com.dearme.demo.domain.user.entity.Certificate;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CounselorProfileRequestDto {
    private Long price;

    private String introduce;

    List<SignUpCareerRequestDto> careers;

    List<SignUpCertificateDto> certificates;

    List<SignUpCategoryRequestDto> categories;

    public List<Career> toCareersEntity(){
        List<Career> careers = new ArrayList<>();
        for(SignUpCareerRequestDto careerDto : this.careers){
            careers.add(careerDto.toEntity());
        }
        return careers;
    }

    public List<Category> toCategoriesEntity(){
        List<Category> categories = new ArrayList<>();
        for(SignUpCategoryRequestDto categoryDto : this.categories){
            categories.add(categoryDto.toEntity());
        }
        return categories;
    }

    public List<Certificate> toCertificatesEntity(){
        List<Certificate> certificates = new ArrayList<>();
        for(SignUpCertificateDto certificateDto : this.certificates){
            certificates.add(certificateDto.toEntity());
        }
        return certificates;
    }
}
