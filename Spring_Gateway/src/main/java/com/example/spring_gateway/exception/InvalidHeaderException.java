package com.example.spring_gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Please send a Bearer token")
public class InvalidHeaderException extends RuntimeException{

    public InvalidHeaderException(String message) {
        super(message);
    }
}
