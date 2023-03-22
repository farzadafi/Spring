package com.example.restfullwebservice.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "this user not found!")
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
