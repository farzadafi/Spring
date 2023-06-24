package com.farzadafi.jdbctemplate.repository.batchSetter;

import com.farzadafi.jdbctemplate.entity.Student;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentBatchSetter implements BatchPreparedStatementSetter {

    private final List<Student> students;

    public StudentBatchSetter(List<Student> students) {
        this.students = students;
    }

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
        Student student = students.get(i);
        ps.setLong(1, student.getId());
        ps.setString(2, student.getFirstName());
        ps.setString(3, student.getLastName());
        ps.setString(4, student.getStudentNumber());
        ps.setInt(5, student.getAge());
        ps.setLong(6, student.getClassroom().getId());
    }

    @Override
    public int getBatchSize() {
        return students.size();
    }
}
