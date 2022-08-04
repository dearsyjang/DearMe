package com.dearme.demo.domain.user.dto;

import com.dearme.demo.domain.user.entity.Certificate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CertificateInfoDto {
    private Long id;
    private String contents;

    public static CertificateInfoDto of(Certificate entity){
        return CertificateInfoDto.builder().id(entity.getId()).contents(entity.getContents()).build();
    }
}
