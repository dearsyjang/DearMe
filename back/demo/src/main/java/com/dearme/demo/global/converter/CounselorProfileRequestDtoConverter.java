package com.dearme.demo.global.converter;

import com.dearme.demo.domain.user.dto.counselorprofile.CounselorProfileRequestDto;
import com.dearme.demo.domain.user.dto.counselorprofile.SignUpCareerRequestDto;
import com.dearme.demo.domain.user.dto.counselorprofile.SignUpCategoryRequestDto;
import com.dearme.demo.domain.user.dto.counselorprofile.SignUpCertificateDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CounselorProfileRequestDtoConverter implements Converter<String, CounselorProfileRequestDto> {
    @Override
    public CounselorProfileRequestDto convert(String source) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(source);
            SignUpCareerRequestDto[] careers = mapper.readValue(root.get("careers").toString(), SignUpCareerRequestDto[].class);
            SignUpCertificateDto[] certificates = mapper.readValue(root.get("certificates").toString(), SignUpCertificateDto[].class);
            SignUpCategoryRequestDto[] categories = mapper.readValue(root.get("categories").toString(), SignUpCategoryRequestDto[].class);
            return CounselorProfileRequestDto.builder()
                    .price(Long.parseLong(root.get("price").toString()))
                    .introduce(root.get("introduce").toString())
                    .careers(Arrays.asList(careers))
                    .categories(Arrays.asList(categories))
                    .certificates(Arrays.asList(certificates))
                    .build();
        } catch (Exception e){
            return null;
        }
    }
}
