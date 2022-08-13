package com.dearme.demo.domain.counselingdocument.controller;

import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentRequestDto;
import com.dearme.demo.domain.counselingdocument.dto.PostGroupCounselingDocumentDto;
import com.dearme.demo.domain.counselingdocument.service.CounselingDocumentServiceImpl;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/counseling-documents")
public class CounselingDocumentController {

    private final CounselingDocumentServiceImpl counselingDocumentService;

    @PostMapping
    public ResponseEntity<CommonResponse> postCounselingDocuments(HttpServletRequest request, @RequestBody @Validated PostCounselingDocumentRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(counselingDocumentService.post(id, dto)), HttpStatus.OK);
    }

    @PostMapping("/groups")
    public ResponseEntity<CommonResponse> postGroupCounselingDocuments(HttpServletRequest request, @RequestBody @Validated PostGroupCounselingDocumentDto dto){
        String id = (String) request.getAttribute("id");
        counselingDocumentService.postGroup(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{counselingDocumentId}")
    public ResponseEntity<CommonResponse> deleteCounselingDocument(HttpServletRequest request, @PathVariable("counselingDocumentId") Long counselingDocumentId){
        String id = (String) request.getAttribute("id");
        counselingDocumentService.deleteUserCounselingDocument(id, counselingDocumentId);
        return ResponseEntity.ok().build();
    }
}
