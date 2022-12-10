package com.example.spring_unittest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "please try again")
public class SaveFailException extends RuntimeException{

    public SaveFailException(String message) {
        super(message);
    }
}
