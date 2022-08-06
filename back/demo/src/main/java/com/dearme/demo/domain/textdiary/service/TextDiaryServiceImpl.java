package com.dearme.demo.domain.textdiary.service;

import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.dto.PostTextDiaryResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryDetailsResponseDto;
import com.dearme.demo.domain.textdiary.dto.TextDiaryListResponseDto;
import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.textdiary.exception.NoPermissionTextDiaryException;
import com.dearme.demo.domain.textdiary.repository.TextDiaryRepository;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.NoPermissionException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TextDiaryServiceImpl implements TextDiaryService{
    private final TextDiaryRepository textDiaryRepository;
    private final UserRepository userRepository;

    @Override
    public PostTextDiaryResponseDto postTextDiary(String id, PostTextDiaryRequestDto dto) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        TextDiary textDiary = dto.toEntity();
        textDiary.setUser(user);
        return new PostTextDiaryResponseDto(textDiaryRepository.save(textDiary).getId());
    }

    @Override
    public TextDiaryDetailsResponseDto getDetails(String id, Long textDiaryId) {
        TextDiary textDiary = textDiaryRepository.findById(textDiaryId).get();
        if(!textDiary.getUser().getId().equals(id)) throw new NoPermissionTextDiaryException();
        return TextDiaryDetailsResponseDto.of(textDiary);
    }

    @Override
    public TextDiaryListResponseDto getList(String id, Integer year, Integer month) {
        List<TextDiary> textDiaries = textDiaryRepository.findAllByUser_IdAndYearAndMonth(id, year, month);
        List<TextDiaryDetailsResponseDto> textDiaryDetailsResponseDtos = new ArrayList<>();
        for(TextDiary textDiary : textDiaries){
            textDiaryDetailsResponseDtos.add(TextDiaryDetailsResponseDto.of(textDiary));
        }
        TextDiaryListResponseDto dto = new TextDiaryListResponseDto();
        dto.setTextDiaries(textDiaryDetailsResponseDtos);
        return dto;
    }
}
