package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.common.CommonStudent;

import java.util.Optional;

public interface StudentRepository {
    boolean existsByStudentNumber(String studentNumber);

    void save(CommonStudent student);

    Optional<CommonStudent> findByStudentNumber(String studentNumber);
}
