package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Certificate;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddCertificateDto {
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;

    public Certificate toEntity(){
        return Certificate.builder().contents(this.contents).build();
    }
}
