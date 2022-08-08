package com.dearme.demo.global.exceptionhandler;

import com.dearme.demo.domain.board.exception.board.NoBoardDeletePermissionException;
import com.dearme.demo.domain.board.exception.board.NoBoardSavePermissionException;
import com.dearme.demo.domain.board.exception.board.NoBoardUpdatePermissionException;
import com.dearme.demo.domain.board.exception.board.NoExistBoardException;
import com.dearme.demo.domain.board.exception.comment.NoCommentDeletePermissionException;
import com.dearme.demo.domain.board.exception.comment.NoCommentSavePermissionException;
import com.dearme.demo.domain.board.exception.comment.NoCommentUpdatePermissionException;
import com.dearme.demo.domain.board.exception.comment.NoExistCommentException;
import com.dearme.demo.domain.counseling.exception.NoExistCounselingException;
import com.dearme.demo.domain.user.exception.*;
import com.dearme.demo.global.common.CommonResponse;
import com.dearme.demo.global.util.jwt.InvalidAccessTokenException;
import com.dearme.demo.global.util.jwt.InvalidRefreshTokenException;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(InvalidAccessTokenException.class)
    ResponseEntity<CommonResponse> handleInvalidAccessTokenException(InvalidAccessTokenException e){
        return new ResponseEntity<>(CommonResponse.getErrorResponse(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidRefreshTokenException.class)
    ResponseEntity<CommonResponse> handleInvalidRefreshTokenException(InvalidRefreshTokenException e){
        return new ResponseEntity<>(CommonResponse.getErrorResponse(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DuplicatedIdException.class)
    ResponseEntity<CommonResponse> handleDuplicatedIdException(DuplicatedIdException e){
        return new ResponseEntity<>(CommonResponse.getErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicatedNickNameException.class)
    ResponseEntity<CommonResponse> handleDuplicatedNickNameException(DuplicatedNickNameException e){
        return new ResponseEntity<>(CommonResponse.getErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NoBoardDeletePermissionException.class)
    ResponseEntity<CommonResponse> handleNoBoardDeletePermissionException(NoBoardDeletePermissionException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(NoBoardSavePermissionException.class)
    ResponseEntity<CommonResponse> handleNoBoardSavePermissionException(NoBoardSavePermissionException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(NoBoardUpdatePermissionException.class)
    ResponseEntity<CommonResponse> handleNoBoardUpdatePermissionException(NoBoardUpdatePermissionException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(NoExistBoardException.class)
    ResponseEntity<CommonResponse> handleNoExistBoardException(NoExistBoardException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(NoCommentDeletePermissionException.class)
    ResponseEntity<CommonResponse> handleNoCommentDeletePermissionException(NoCommentDeletePermissionException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(NoCommentSavePermissionException.class)
    ResponseEntity<CommonResponse> handleNoCommentSavePermissionException(NoCommentSavePermissionException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(NoCommentUpdatePermissionException.class)
    ResponseEntity<CommonResponse> handleNoCommentUpdatePermissionException(NoCommentUpdatePermissionException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(NoExistCommentException.class)
    ResponseEntity<CommonResponse> handleNoExistCommentException(NoExistCommentException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(NoExistCounselingException.class)
    ResponseEntity<CommonResponse> handleNoExistCounselingException(NoExistCounselingException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(NoExistCareerException.class)
    ResponseEntity<CommonResponse> handleNoExistCareerException(NoExistCareerException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(NoExistCertificateException.class)
    ResponseEntity<CommonResponse> handleNoExistCertificateException(NoExistCertificateException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(NoExistCategoryException.class)
    ResponseEntity<CommonResponse> handleNoExistCategoryException(NoExistCategoryException e){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(e.getMessage()));
    }
}
