package com.example.spring_unittest.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class SaveFailException extends RuntimeException{

    public SaveFailException(String message) {
        super(message);
    }
}
