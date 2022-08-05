package com.dearme.demo.domain.textdiary.service;

import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.dto.PostTextDiaryResponseDto;
import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.textdiary.repository.TextDiaryRepository;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TextDiaryServiceImpl implements TextDiaryService{
    private final TextDiaryRepository textDiaryRepository;
    private final UserRepository userRepository;

    @Override
    public PostTextDiaryResponseDto postTextDiary(String id, PostTextDiaryRequestDto dto) {
        System.out.println(id);
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        TextDiary textDiary = dto.toEntity();
        textDiary.setUser(user);
        return new PostTextDiaryResponseDto(textDiaryRepository.save(textDiary).getId());
    }
}
