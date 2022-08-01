package com.dearme.demo.domain.user.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Picture {
    private String realFileName;
    private String fileName;

    @Builder
    public Picture(String realFileName, String fileName){
        this.realFileName = realFileName;
        this.fileName = fileName;
    }
}
