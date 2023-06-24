package com.farzadafi.jdbctemplate.dto;

public record ResponseDto<T>(String message,
                             T info) {
}
