package com.dearme.demo.domain.user.service;

import com.dearme.demo.domain.user.dto.SignUpRequestDto;
import com.dearme.demo.domain.user.dto.SignUpResponseDto;
import com.dearme.demo.domain.user.entity.*;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.dearme.demo.global.util.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final JwtProvider jwtProvider;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public SignUpResponseDto signUpUser(SignUpRequestDto dto) {
        Picture picture = null;
        User user = null;
        if(dto.getType().equals(Type.USER)){
            user = dto.toUserEntity();
        }
        else{
            user = dto.toCounselorEntity();
            CounselorProfile counselorProfile = dto.toCounselorProfileEntity();
            List<Career> careers = dto.getCounselorProfile().toCareersEntity();
            List<Certificate> certificates = dto.getCounselorProfile().toCertificatesEntity();
            List<Category> categories = dto.getCounselorProfile().toCategoriesEntity();
            counselorProfile.setCareers(careers);
            counselorProfile.setCategories(categories);
            counselorProfile.setCertificates(certificates);
            counselorProfile.setValue(0L);
            user.setCounselorProfile(counselorProfile);
        }
        if(dto.getPicture() != null){
            picture = Picture.builder().fileName(dto.getPicture().getOriginalFilename()).realFileName(UUID.randomUUID().toString()).build();
            File file = new File("C:\\Users\\multicampus\\Desktop\\project\\S07P12D206\\back\\demo\\src\\main\\resources\\static\\" + picture.getRealFileName() + ".jpeg");
            System.out.println(picture.getRealFileName());
            try {
                dto.getPicture().transferTo(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            user.setPicture(picture);
        }
        userRepository.save(user);

        return SignUpResponseDto
                .builder()
                .accessToken(jwtProvider.getAccessToken(user.getId()))
                .refreshToken(jwtProvider.getRefreshToken())
                .build();
    }
}
