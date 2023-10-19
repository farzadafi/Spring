package com.farzadafi.springbase.service;

import com.farzadafi.springbase.model.Student;

public interface StudentService {
    void register(Student student);
    Student findByStudentNumber(String studentNumber);
}
