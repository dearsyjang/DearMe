package com.dearme.demo.domain.counselingdocument.service;

import com.dearme.demo.domain.counselingdocument.dto.CounselingDocumentInfoResponseDto;
import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentRequestDto;
import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentResponseDto;
import com.dearme.demo.domain.counselingdocument.dto.PostGroupCounselingDocumentDto;

public interface CounselingDocumentService {
    PostCounselingDocumentResponseDto post(String id, PostCounselingDocumentRequestDto dto);

    void postGroup(String id, PostGroupCounselingDocumentDto dto);

    void deleteUserCounselingDocument(String id, Long counselingDocumentId);

    CounselingDocumentInfoResponseDto getCounselingDocument(String id, Long counselingDocumentId);
}
