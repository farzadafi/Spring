package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.common.CommonStudent;
import com.farzadafi.springbase.model.jpa.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Integer> {
    Optional<CommonStudent> findByStudentNumber(String studentNumber);
}
