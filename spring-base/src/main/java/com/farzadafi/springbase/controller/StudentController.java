package com.farzadafi.springbase.controller;

import com.farzadafi.springbase.model.Student;
import com.farzadafi.springbase.model.common.CommonStudent;
import com.farzadafi.springbase.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping()
    public ResponseEntity<String> register() {
        CommonStudent commonStudent = new CommonStudent(null, "farzad", "303");
        service.register(commonStudent);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @GetMapping()
    public Student findByStudentNumber() {
        return service.findByStudentNumber("303");
    }
}
