package com.dearme.demo.global.config.webserver;

import com.dearme.demo.global.converter.CounselorProfileRequestDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final CounselorProfileRequestDtoConverter counselorProfileRequestDtoConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(counselorProfileRequestDtoConverter);
    }
}
