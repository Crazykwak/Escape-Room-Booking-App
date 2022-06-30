package com.crazykwak.roombooking.exception.handle;

import com.crazykwak.roombooking.exception.ExceptionCode;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {
    private int status;
    private String message;

    private ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ErrorResponse of(ExceptionCode exceptionCode) {
        return new ErrorResponse(exceptionCode.getStatus(), exceptionCode.getMessage());
    }

//    @Getter
//    public static class FieldErrors {
//        private String field;
//        private Object rejectValue;
//        private String reason;
//
//        private FieldErrors(String field, Object rejectValue, String reason) {
//            this.field = field;
//            this.rejectValue = rejectValue;
//            this.reason = reason;
//        }
//
//        public static List<FieldErrors> of(BindingResult bindingResult) {
//            final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//
//            return fieldErrors.stream()
//                        .map(e -> new FieldErrors(
//                                e.getField(),
//                                e.getRejectedValue() == null ?
//                                "" : e.getRejectedValue().toString(),
//                                e.getDefaultMessage()
//                        ))
//                        .collect(Collectors.toList());
//        }
//    }
}
