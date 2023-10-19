package com.farzadafi.springbase.service;

import com.farzadafi.springbase.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class LogEnabledStudentService implements StudentService {
    private final StudentService service;

    @Override
    public void register(Student student) {
        log.info("registration request {}", student);
        service.register(student);
    }
}