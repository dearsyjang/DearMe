package com.dearme.demo.global.exceptionhandler;

import com.dearme.demo.domain.user.exception.*;
import com.dearme.demo.global.common.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerUtil {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<CommonResponse> handleMethodArgumentNotValidException(BindingResult bindingResult){
        return ResponseEntity.badRequest().body(CommonResponse.getFailResponse(bindingResult));
    }

    @ExceptionHandler(NoExistUserException.class)
    ResponseEntity<CommonResponse> handleNoExistUserException(NoExistUserException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(BindException.class)
    ResponseEntity<CommonResponse> handleBindException(BindException e){
        return ResponseEntity.badRequest().body(CommonResponse.getFailResponse(e.getBindingResult()));
    }

    @ExceptionHandler(CounselorProfileValidationException.class)
    ResponseEntity<CommonResponse> handleConversionFailedException(CounselorProfileValidationException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(CounselorNotExistPictureException.class)
    ResponseEntity<CommonResponse> handleCounselorNotExistPictureException(CounselorNotExistPictureException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
}
