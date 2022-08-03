package com.dearme.demo.domain.user.controller;

import com.dearme.demo.domain.user.dto.LoginRequestDto;
import com.dearme.demo.domain.user.dto.SignUpRequestDto;
import com.dearme.demo.domain.user.service.UserService;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<CommonResponse> signUpUser(@ModelAttribute @Validated SignUpRequestDto dto) throws IOException {
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.signUpUser(dto)), HttpStatus.OK);
    }

    @GetMapping("/token")
    public ResponseEntity<CommonResponse> login(@Validated LoginRequestDto dto){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.login(dto)), HttpStatus.OK);
    }
}
