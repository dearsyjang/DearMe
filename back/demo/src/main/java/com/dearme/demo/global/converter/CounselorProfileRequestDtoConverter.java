package com.dearme.demo.global.converter;

import com.dearme.demo.domain.user.dto.CounselorProfileRequestDto;
import com.dearme.demo.domain.user.dto.SignUpCareerRequestDto;
import com.dearme.demo.domain.user.dto.SignUpCategoryRequestDto;
import com.dearme.demo.domain.user.dto.SignUpCertificateDto;
import com.dearme.demo.domain.user.exception.CounselorProfileValidationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.ConversionFailedException;
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
