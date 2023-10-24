package com.farzadafi.springbase.service;

import com.farzadafi.springbase.model.Student;
import com.farzadafi.springbase.model.common.CommonStudent;
import com.farzadafi.springbase.repository.JdbcStudentRepository;
import com.farzadafi.springbase.repository.StudentRepository;

public class StudentServiceImpel implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpel(JdbcStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(CommonStudent student) {
        repository.save(student);
    }

    @Override
    public Student findByStudentNumber(String studentNumber) {
        return repository.findByStudentNumber(studentNumber).orElseThrow(
                () -> new RuntimeException("not found!"));
    }
}
