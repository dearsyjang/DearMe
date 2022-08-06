package com.dearme.demo.domain.counselingdocument.controller;

import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentRequestDto;
import com.dearme.demo.domain.counselingdocument.service.CounselingDocumentServiceImpl;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/counseling-documents")
public class CounselingDocumentController {

    private final CounselingDocumentServiceImpl counselingDocumentService;

    public ResponseEntity<CommonResponse> postCounselingDocuments(HttpServletRequest request, @RequestBody PostCounselingDocumentRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(counselingDocumentService.post(id, dto)), HttpStatus.OK);
    }
}
