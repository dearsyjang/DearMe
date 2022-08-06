package com.dearme.demo.domain.counselingdocument.service;

import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentRequestDto;
import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentResponseDto;

public interface CounselingDocumentService {
    PostCounselingDocumentResponseDto post(String id, PostCounselingDocumentRequestDto dto);
}
