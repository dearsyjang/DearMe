package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Certificate;
import lombok.Data;

@Data
public class AddCertificateDto {
    private String contents;

    public Certificate toEntity(){
        return Certificate.builder().contents(this.contents).build();
    }
}
