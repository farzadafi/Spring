package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.common.CommonStudent;

public interface StudentRepository {
    boolean existsByStudentNumber(String studentNumber);

    void save(CommonStudent student);

    CommonStudent findByStudentNumber(String studentNumber);
}
