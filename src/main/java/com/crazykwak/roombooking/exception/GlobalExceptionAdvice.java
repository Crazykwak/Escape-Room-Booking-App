package com.crazykwak.roombooking.exception;

import com.crazykwak.roombooking.exception.handle.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    public String handleBusinessException(BusinessException e) {
        String message = e.getExceptionCode().getMessage();
        log.info("What the fuck = {}",message);

        return "errorPage";
    }

//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse handleMethodArgumentNotValidException(
//            MethodArgumentNotValidException e) {
//        final ErrorResponse response = ErrorResponse.of(e.getBindingResult());
//        log.info("status = {}", response.getStatus());
//        log.info("message = {}", response.getMessage());
//
//        return response;
//    }
}
