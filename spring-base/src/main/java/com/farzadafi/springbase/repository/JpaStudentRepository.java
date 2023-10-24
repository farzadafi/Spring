package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.common.CommonStudent;
import com.farzadafi.springbase.model.jpa.StudentEntity;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaStudentRepository implements StudentRepository{

    private final StudentJpaRepository repository;

    @Override
    public boolean existsByStudentNumber(String studentNumber) {
        Optional<CommonStudent> byStudentNumber = repository.findByStudentNumber(studentNumber);
        return byStudentNumber.isPresent();
    }

    @Override
    public void save(CommonStudent student) {
        repository.save(new StudentEntity(student));
    }

    @Override
    public Optional<CommonStudent> findByStudentNumber(String studentNumber) {
        return repository.findByStudentNumber(studentNumber);
    }
}
