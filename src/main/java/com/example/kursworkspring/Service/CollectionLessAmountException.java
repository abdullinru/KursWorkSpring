package com.example.kursworkspring.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CollectionLessAmountException extends RuntimeException {
    public CollectionLessAmountException() {
    }

    public CollectionLessAmountException(String message) {
        super(message);
    }

    public CollectionLessAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public CollectionLessAmountException(Throwable cause) {
        super(cause);
    }

    public CollectionLessAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
