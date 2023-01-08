package com.example.authentication_server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This username already exists")
public class UserNameDuplicateException extends RuntimeException{

    public UserNameDuplicateException(String message) {
        super(message);
    }
}
