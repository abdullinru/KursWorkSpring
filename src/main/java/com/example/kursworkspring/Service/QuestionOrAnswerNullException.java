package com.example.kursworkspring.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionOrAnswerNullException extends RuntimeException {
    public QuestionOrAnswerNullException() {
    }

    public QuestionOrAnswerNullException(String message) {
        super(message);
    }

    public QuestionOrAnswerNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionOrAnswerNullException(Throwable cause) {
        super(cause);
    }

    public QuestionOrAnswerNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
