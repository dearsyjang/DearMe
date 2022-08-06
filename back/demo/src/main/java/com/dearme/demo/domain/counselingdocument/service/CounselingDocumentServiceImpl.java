package com.dearme.demo.domain.counselingdocument.service;

import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentRequestDto;
import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentResponseDto;
import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import com.dearme.demo.domain.counselingdocument.repository.CounselingDocumentRepository;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounselingDocumentServiceImpl implements CounselingDocumentService{

    private final UserRepository userRepository;

    private final CounselingDocumentRepository counselingDocumentRepository;

    @Override
    public PostCounselingDocumentResponseDto post(String id, PostCounselingDocumentRequestDto dto) {
        CounselingDocument counselingDocument = dto.toEntity();
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        User counselor = userRepository.findById(dto.getCounselorId()).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        counselingDocument.setUser(user);
        counselingDocument.setCounselor(counselor);
        return new PostCounselingDocumentResponseDto(counselingDocumentRepository.save(counselingDocument).getId());
    }
}
