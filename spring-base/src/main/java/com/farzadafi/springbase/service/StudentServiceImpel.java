package com.farzadafi.springbase.service;

import com.farzadafi.springbase.model.common.CommonStudent;
import com.farzadafi.springbase.repository.JdbcStudentRepository;
import com.farzadafi.springbase.repository.StudentRepository;

public class StudentServiceImpel implements StudentService {

//    private final JdbcStudentRepository repository;
    private final StudentRepository repository;

    public StudentServiceImpel(JdbcStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(CommonStudent student1) {
        CommonStudent student = new CommonStudent(null, "farzad", "3033333333");
        repository.save(student);
    }
}
