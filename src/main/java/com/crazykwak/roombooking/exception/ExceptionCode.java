package com.crazykwak.roombooking.exception;

import lombok.Getter;

public enum ExceptionCode {
    FRANCHISE_NOT_FOUND(404, "프렌차이즈가 없습니다."),
    FRANCHISE_EXISTS(409, "이미 등록된 프렌차이즈입니다."),
    THEMES_EXISTS(409, "이미 등록된 테마입니다."),
    THEMES_NOT_FOUND(404, "테마가 존재하지 않습니다."),
    THEMESTAG_NOT_FOUND(404, "테마,태그 테이블이 없습니다."),
    TAG_NOT_FOUND(404, "태그가 없습니다."),
    THEMESTIME_NOT_FOUND(404, "존재하지 않는 예약 시간 입니다.");

    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
