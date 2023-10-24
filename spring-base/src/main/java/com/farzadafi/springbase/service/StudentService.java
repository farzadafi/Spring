package com.farzadafi.springbase.service;

import com.farzadafi.springbase.model.Student;
import com.farzadafi.springbase.model.common.CommonStudent;

public interface StudentService {
    void register(CommonStudent student);
    Student findByStudentNumber(String studentNumber);
}