package com.dearme.demo.domain.counselingdocument.service;

import com.dearme.demo.domain.counseling.service.CounselingServiceImpl;
import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentRequestDto;
import com.dearme.demo.domain.counselingdocument.dto.PostCounselingDocumentResponseDto;
import com.dearme.demo.domain.counselingdocument.dto.PostGroupCounselingDocumentDto;
import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import com.dearme.demo.domain.counselingdocument.exception.CounselorCreateCounselingException;
import com.dearme.demo.domain.counselingdocument.exception.NoExistDocumentException;
import com.dearme.demo.domain.counselingdocument.repository.CounselingDocumentRepository;
import com.dearme.demo.domain.favorite.entity.Favorite;
import com.dearme.demo.domain.favorite.exception.NoExistFavoriteException;
import com.dearme.demo.domain.favorite.exception.NoFavoriteDeletePermissionException;
import com.dearme.demo.domain.group.entity.Group;
import com.dearme.demo.domain.group.exception.GroupNotFoundExcetion;
import com.dearme.demo.domain.group.repository.GroupRepository;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistCounselorException;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CounselingDocumentServiceImpl implements CounselingDocumentService{

    private final UserRepository userRepository;

    private final CounselingDocumentRepository counselingDocumentRepository;

    private final CounselingServiceImpl counselingService;

    private final GroupRepository groupRepository;

    @Override
    @Transactional
    public PostCounselingDocumentResponseDto post(String id, PostCounselingDocumentRequestDto dto) {
        CounselingDocument counselingDocument = dto.toEntity();
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getType().equals(Type.COUNSELOR)){
            throw new CounselorCreateCounselingException();
        }
        User counselor = userRepository.findById(dto.getId()).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        counselingDocument.setUser(user);
        counselingDocument.setCounselor(counselor);
        counselingService.createCounseling(counselingDocument);
        return new PostCounselingDocumentResponseDto(counselingDocumentRepository.save(counselingDocument).getId());
    }

    @Override
    @Transactional
    public void postGroup(String id, PostGroupCounselingDocumentDto dto) {
        CounselingDocument counselingDocument = dto.toEntity();
        Group group = groupRepository.findById(dto.getId()).orElseThrow(() -> {
            throw new GroupNotFoundExcetion();
        });
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        if(user.getType().equals(Type.COUNSELOR)){
            throw new CounselorCreateCounselingException();
        }
        counselingDocument.setUser(user);
        counselingDocument.setGroup(group);
        counselingDocument.setCounselor(group.getCounselor());
        counselingService.createGroupCounseling(counselingDocument);
        counselingDocumentRepository.save(counselingDocument);
    }

    @Override
    @Transactional
    public void deleteUserCounselingDocument(String id, Long counselingDocumentId) {
        userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        counselingDocumentRepository.findById(counselingDocumentId).orElseThrow(() -> {
            throw new NoExistDocumentException();
        });
        counselingDocumentRepository.deleteCounselingDocumentByUser_IdAndId(id, counselingDocumentId);
    }
}
