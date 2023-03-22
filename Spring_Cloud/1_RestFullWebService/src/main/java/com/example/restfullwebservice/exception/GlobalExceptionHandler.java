package com.example.restfullwebservice.exception;

import com.example.restfullwebservice.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> userNotFoundExceptionHandler(UserNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), 404);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
