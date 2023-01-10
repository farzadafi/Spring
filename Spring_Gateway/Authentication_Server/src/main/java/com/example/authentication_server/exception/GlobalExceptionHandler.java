package com.example.authentication_server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundHandler(UserNotFoundException e) {

        CustomException exception = new CustomException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        return new ResponseEntity<>(exception, exception.httpStatus());
    }

    @ExceptionHandler(UserNameDuplicateException.class)
    public ResponseEntity<?> usernameDuplicateHandler(UserNameDuplicateException e) {

        CustomException exception = new CustomException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(exception, exception.httpStatus());
    }
}
