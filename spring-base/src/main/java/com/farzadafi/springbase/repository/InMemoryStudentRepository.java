package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryStudentRepository implements StudentRepository {
    private final Map<String, Student> database = new HashMap<>();

    @Override
    public boolean existsByStudentNumber(String studentNumber) {
        return database.containsKey(studentNumber);
    }

    @Override
    public void save(Student student) {
        database.put(student.getStudentNumber(), student);
    }

    @Override
    public Optional<Student> findByStudentNumber(String studentNumber) {
        return Optional.ofNullable(database.get(studentNumber));
    }
}
