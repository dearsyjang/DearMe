package com.dearme.demo.global.util.jwt;

import com.dearme.demo.domain.user.exception.NoExistUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AccessTokenInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        if(request.getMethod().equals("POST")) return true;
        try {
            String accessToken = getAccessToken(request.getHeader(HttpHeaders.AUTHORIZATION));
            request.setAttribute("id", jwtProvider.getIdFromAccessToken(accessToken));
            return true;
        }catch (Exception e) {
            throw new InvalidAccessTokenException();
        }
    }

    private String getAccessToken(String authorization){
        return authorization.split(" ")[1];
    }
}
