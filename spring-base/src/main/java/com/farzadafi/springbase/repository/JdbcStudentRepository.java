package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class JdbcStudentRepository implements StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcStudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean existsByStudentNumber(String studentNumber) {
        String sql = """
                select  count(*)
                from student
                where student_number = ?
                """;
        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                studentNumber
        );
        return count != null && count == 1;
    }

    @Override
    public void save(Student student) {
        String sql = """
                insert into student(name, student_number)
                values (?, ?)
                """;
        jdbcTemplate.update(
                sql,
                student.getFullName(),
                student.getStudentNumber()
        );
    }

    @Override
    public Optional<Student> findByStudentNumber(String studentNumber) {
        String sql = """
                select name,student_number
                from student
                where student_number = ?
                """;
        return jdbcTemplate.query(
                        sql,
                        (rs, rowNum) -> new Student(null,
                                rs.getString("name"),
                                rs.getString("student_number")
                        ),
                        studentNumber)
                .stream()
                .map(Student.class::cast)
                .findFirst();
    }
}
