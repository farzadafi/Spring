package com.farzadafi.springbase.repository;

import com.farzadafi.springbase.model.common.CommonStudent;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public void save(CommonStudent student) {
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
    public CommonStudent findByStudentNumber(String studentNumber) {
        String sql = """
                select name,student_number
                from student
                where student_number = ?
                """;
        return jdbcTemplate.query(
                        sql,
                        (rs, rowNum) -> new CommonStudent(null,
                                rs.getString("name"),
                                rs.getString("student_number")
                        ),
                        studentNumber)
                .stream()
                .map(CommonStudent.class::cast)
                .findFirst().get();
    }
}
