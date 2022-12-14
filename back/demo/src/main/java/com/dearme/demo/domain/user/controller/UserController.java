package com.dearme.demo.domain.user.controller;

import com.dearme.demo.domain.user.dto.counselorprofile.*;
import com.dearme.demo.domain.user.dto.etc.PointsUpdateRequestDto;
import com.dearme.demo.domain.user.dto.user.*;
import com.dearme.demo.domain.user.service.UserService;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/nickname/{nickName}")
    public ResponseEntity<?> checkNickname(@PathVariable("nickName") String nickName){
        userService.checkNickname(nickName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping
    public void delete(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        userService.delete(id);
    }

    @PutMapping("/points")
    public ResponseEntity<CommonResponse> pointsUpdate(HttpServletRequest request, @RequestBody @Validated PointsUpdateRequestDto dto) throws UnsupportedEncodingException {
         String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.pointsUpdate(id, dto.getPrice())), HttpStatus.OK);
    }

    @GetMapping("/reviews")
    public ResponseEntity<CommonResponse> getReviews(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.getReviews(id)), HttpStatus.OK);
    }

    @GetMapping("/groups")
    public ResponseEntity<CommonResponse> getGroups(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.getGroups(id)), HttpStatus.OK);
    }

    @DeleteMapping("/careers/{careerId}")
    public void deleteCareer(HttpServletRequest request, @PathVariable(value = "careerId") Long careerId){
        String id = (String) request.getAttribute("id");
        userService.deleteCareer(id, careerId);
    }

    @DeleteMapping("/certificate/{certificateId}")
    public void deleteCertificate(HttpServletRequest request, @PathVariable(value = "certificateId") Long certificateId){
        String id = (String) request.getAttribute("id");
        userService.deleteCounselorCertificate(id, certificateId);
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(HttpServletRequest request, @PathVariable(value = "categoryId") Long categoryId){
        String id = (String) request.getAttribute("id");
        userService.deleteCounselorCategory(id, categoryId);
    }

    @PostMapping("/careers")
    public ResponseEntity<CommonResponse> addCareer(HttpServletRequest request, @RequestBody AddCareerRequestDto dto){
        String id = (String) request.getAttribute("id");
        userService.addCounselorCareer(id, dto);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/certificates")
    public ResponseEntity<CommonResponse> addCertificate(HttpServletRequest request, @RequestBody AddCertificateDto dto){
        String id = (String) request.getAttribute("id");
        userService.addCounselorCertificate(id, dto);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/categories")
    public ResponseEntity<CommonResponse> addCategory(HttpServletRequest request, @RequestBody AddCategoryRequestDto dto){
        String id = (String) request.getAttribute("id");
        userService.addCounselorCategory(id, dto);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/users/groups/{groupId}")
    public ResponseEntity<CommonResponse> withdrawalGroup(HttpServletRequest request, @PathVariable("groupId") Long groupId){
        String id = (String) request.getAttribute("id");
        userService.withdrawalUserGroup(id, groupId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{userId}/image", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] userProfileImage(HttpServletRequest request, @PathVariable("userId") Long userId) throws IOException {
//        String id = (String) request.getAttribute ("id");
        return userService.getUserProfileImage(userId);
    }

    @PutMapping("/image")
    public ResponseEntity<CommonResponse> updateProfileImage(HttpServletRequest request,@RequestParam MultipartFile picture) throws IOException {
        String id = (String) request.getAttribute("id");
        userService.updateUserProfileImage(id, picture);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CommonResponse> counselorRequestUserInfo(HttpServletRequest request, @PathVariable("userId") Long userId){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(userService.getUserInfo(id, userId)), HttpStatus.OK);
    }
}
