package com.example.spring_unittest.exception;

public class UsernameDuplicateException extends RuntimeException{

    public UsernameDuplicateException(String message) {
        super(message);
    }
}
