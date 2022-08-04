package com.dearme.demo.domain.textdiary.service;

import com.dearme.demo.domain.textdiary.repository.TextDiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TextDiaryServiceImpl implements TextDiaryService{
    private final TextDiaryRepository textDiaryRepository;
}
