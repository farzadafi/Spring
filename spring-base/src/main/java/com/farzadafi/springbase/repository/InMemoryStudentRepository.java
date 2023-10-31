package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.common.CommonStudent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryStudentRepository implements StudentRepository {
    private final Map<String, CommonStudent> database = new HashMap<>();

    @Override
    public boolean existsByStudentNumber(String studentNumber) {
        return database.containsKey(studentNumber);
    }

    @Override
    public void save(CommonStudent student) {
        database.put(student.getStudentNumber(), student);
    }

    @Override
    public CommonStudent findByStudentNumber(String studentNumber) {
        return Optional.ofNullable(database.get(studentNumber)).get();
    }
}
