package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.Student;

import java.util.Optional;

public interface StudentRepository {
    boolean existsByStudentNumber(String studentNumber);

    void save(Student student);

    Optional<Student> findByStudentNumber(String studentNumber);
}
