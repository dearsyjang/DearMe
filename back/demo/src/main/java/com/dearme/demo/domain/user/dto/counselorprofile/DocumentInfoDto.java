package com.dearme.demo.domain.user.dto.counselorprofile;

import com.dearme.demo.domain.user.entity.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentInfoDto {
    private Long id;
    private String realFileName;
    private String fileName;

    public static DocumentInfoDto of(Document entity){
        return DocumentInfoDto.builder().
                id(entity.getId()).
                realFileName(entity.getRealFileName())
                .fileName(entity.getFileName())
                .build();
    }
}
