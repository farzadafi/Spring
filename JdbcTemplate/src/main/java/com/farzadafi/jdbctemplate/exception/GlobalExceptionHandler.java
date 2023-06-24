package com.farzadafi.jdbctemplate.exception;

import com.farzadafi.jdbctemplate.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadSqlGrammarException.class)
    public ResponseEntity<ResponseDto<Date>> badSqlGrammarExceptionHandler(BadSqlGrammarException e) {
        ResponseDto<Date> responseDto = new ResponseDto<>("column or table name is not exist", new Date());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ResponseDto<Date>> IOExceptionHandler(IOException e) {
        ResponseDto<Date> responseDto = new ResponseDto<>(e.getMessage(), new Date());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ResponseDto<Date>> SQLExceptionHandler(SQLException e) {
        ResponseDto<Date> responseDto = new ResponseDto<>(e.getMessage(), new Date());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
