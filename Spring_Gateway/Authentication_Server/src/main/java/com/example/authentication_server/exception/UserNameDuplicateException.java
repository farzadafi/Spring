package com.example.authentication_server.exception;

public class UserNameDuplicateException extends RuntimeException{

    public UserNameDuplicateException(String message) {
        super(message);
    }
}
