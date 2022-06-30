package com.crazykwak.roombooking.exception;

import lombok.Getter;

public class BusinessException extends RuntimeException {

    @Getter
    private ExceptionCode exceptionCode;

    public BusinessException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
