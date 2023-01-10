package com.example.authentication_server.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public record CustomException(HttpStatus httpStatus, String message) {
}
