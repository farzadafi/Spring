package com.farzadafi.springbase.service;

import com.farzadafi.springbase.model.Student;
import com.farzadafi.springbase.repository.JdbcStudentRepository;

public class StudentServiceImpel implements StudentService {

    private final JdbcStudentRepository repository;

    public StudentServiceImpel(JdbcStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(Student student1) {
        Student student = new Student(null, "farzad", "3033333333");
        repository.save(student);
    }
}
