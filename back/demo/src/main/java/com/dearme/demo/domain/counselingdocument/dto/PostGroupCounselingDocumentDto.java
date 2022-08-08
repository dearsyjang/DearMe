package com.dearme.demo.domain.counselingdocument.dto;

import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import lombok.Data;

@Data
public class PostGroupCounselingDocumentDto {
    private Long id;
    private String contents;
    private Boolean isOpen;

    public CounselingDocument toEntity(){
        return CounselingDocument.builder().contents(this.contents).isOpen(isOpen).build();
    }
}
