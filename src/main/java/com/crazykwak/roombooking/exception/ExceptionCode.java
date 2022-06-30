package com.crazykwak.roombooking.exception;

import lombok.Getter;

public enum ExceptionCode {
    FRANCHISE_NOT_FOUND(404, "프렌차이즈가 없습니다."),
    FRANCHISE_EXISTS(409, "이미 등록된 프렌차이즈입니다.");

    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
