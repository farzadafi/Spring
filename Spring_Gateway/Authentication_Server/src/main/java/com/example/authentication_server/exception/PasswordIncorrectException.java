package com.example.authentication_server.exception;

public class PasswordIncorrectException extends RuntimeException{

    public PasswordIncorrectException(String message) {
        super(message);
    }
}
