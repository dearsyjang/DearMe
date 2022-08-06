package com.dearme.demo.global.config.webserver;

import com.dearme.demo.global.converter.CounselorProfileRequestDtoConverter;
import com.dearme.demo.global.util.jwt.AccessTokenInterceptor;
import com.dearme.demo.global.util.jwt.RefreshTokenInterceptor;
import io.openvidu.java.client.OpenVidu;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final CounselorProfileRequestDtoConverter counselorProfileRequestDtoConverter;

    private final AccessTokenInterceptor accessTokenInterceptor;

    private final RefreshTokenInterceptor refreshTokenInterceptor;

    @Value("${openvidu.openvidu_url}")
    private String OPENVIDU_URL;
    @Value("${openvidu.password}")
    private String SECRET;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(counselorProfileRequestDtoConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(refreshTokenInterceptor).addPathPatterns("/users/access-token");
        registry.addInterceptor(accessTokenInterceptor).excludePathPatterns(Arrays.asList(new String[]{"/users/token", "/users/id/{id}", "/users/nickname/{nickname}", "/users/id", "/users/password", "/h2-console"}));
    }

    @Bean
    public OpenVidu getOpenVidu(){
        return new OpenVidu(OPENVIDU_URL, SECRET);
    }
}
