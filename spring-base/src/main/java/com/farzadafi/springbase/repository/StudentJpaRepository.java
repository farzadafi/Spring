package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
}
