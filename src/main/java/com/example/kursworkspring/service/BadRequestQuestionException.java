package com.example.kursworkspring.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestQuestionException extends RuntimeException {
    public BadRequestQuestionException() {
    }

    public BadRequestQuestionException(String message) {
        super(message);
    }

    public BadRequestQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestQuestionException(Throwable cause) {
        super(cause);
    }

    public BadRequestQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
