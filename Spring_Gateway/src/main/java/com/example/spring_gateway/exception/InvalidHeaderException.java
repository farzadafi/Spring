package com.example.spring_gateway.exception;

public class InvalidHeaderException extends RuntimeException{

    public InvalidHeaderException(String message) {
        super(message);
    }
}
