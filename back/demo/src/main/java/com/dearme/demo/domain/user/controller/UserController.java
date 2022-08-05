package com.dearme.demo.domain.user.controller;

import com.dearme.demo.domain.user.dto.*;
import com.dearme.demo.domain.user.service.UserService;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<CommonResponse> getUserInfo(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.getUserInfo(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommonResponse> signUpUser(@ModelAttribute @Validated SignUpRequestDto dto) throws IOException {
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.signUpUser(dto)), HttpStatus.OK);
    }

    @GetMapping("/token")
    public ResponseEntity<CommonResponse> login(@Validated LoginRequestDto dto){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.login(dto)), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CommonResponse> update(HttpServletRequest request,@RequestBody @Validated UpdateUserRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.update(id, dto)), HttpStatus.OK);
    }

    @GetMapping("/access-token")
    public ResponseEntity<CommonResponse> getAccessToken(HttpServletRequest request){
        String refreshToken = (String) request.getAttribute("refreshToken");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.getAccessToken(refreshToken)), HttpStatus.OK);
    }

    @PutMapping("/careers")
    public ResponseEntity<CommonResponse> updateCareer(HttpServletRequest request, @RequestBody @Validated UpdateCareerRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.updateCareer(id, dto)), HttpStatus.OK);
    }

    @PutMapping("/categories")
    public ResponseEntity<CommonResponse> updateCategory(HttpServletRequest request,  @RequestBody @Validated UpdateCategoryRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.updateCategory(id, dto)), HttpStatus.OK);
    }

    @PutMapping("/certificates")
    public ResponseEntity<CommonResponse> updateCertificate(HttpServletRequest request, @RequestBody @Validated UpdateCertificateRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.updateCertificate(id, dto)), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> checkId(@PathVariable("id") String id){
        userService.checkId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<?> checkNickname(@PathVariable("nickname") String nickname){
        userService.checkNickname(nickname);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public void delete(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        userService.delete(id);
    }

    @PostMapping("/points")
    public void pointsUpdate(HttpServletRequest request) throws UnsupportedEncodingException {
        String id = request.getParameter("id");
        String price = request.getParameter("price");
        userService.pointsUpdate(id, price);
    }

    @GetMapping("/reviews")
    public ResponseEntity<CommonResponse> getReviews(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.getReviews(id)), HttpStatus.OK);
    }
}
