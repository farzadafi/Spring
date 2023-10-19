package com.farzadafi.springbase.service;

import com.farzadafi.springbase.model.Student;
import com.farzadafi.springbase.repository.JdbcStudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpel implements StudentService {

    private final JdbcStudentRepository repository;

    public StudentServiceImpel(JdbcStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    @PostConstruct
    public void register() {
        Student student = new Student(null, "farzad", "3033333333");
        repository.save(student);
    }

    @Override
    public Student findByStudentNumber(String studentNumber) {
        return repository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new RuntimeException("username not found"));
    }
}
