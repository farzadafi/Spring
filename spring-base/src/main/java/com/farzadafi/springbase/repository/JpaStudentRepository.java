package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.Student;
import com.farzadafi.springbase.model.common.CommonStudent;
import com.farzadafi.springbase.model.jpa.StudentEntity;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaStudentRepository implements StudentRepository{

    private final StudentJpaRepository repository;

    @Override
    public boolean existsByStudentNumber(String studentNumber) {
        Optional<Student> byStudentNumber = repository.findByStudentNumber(studentNumber);
        return byStudentNumber.isPresent();
    }

    @Override
    public void save(CommonStudent student) {
        repository.save(new StudentEntity(student));
    }

    @Override
    public CommonStudent findByStudentNumber(String studentNumber) {
        return (CommonStudent) repository.findByStudentNumber(studentNumber).get();
    }
}
