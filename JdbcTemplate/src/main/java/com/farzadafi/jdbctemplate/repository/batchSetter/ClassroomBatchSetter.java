package com.farzadafi.jdbctemplate.repository.batchSetter;

import com.farzadafi.jdbctemplate.entity.Classroom;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClassroomBatchSetter implements BatchPreparedStatementSetter {

    private final List<Classroom> classrooms;

    public ClassroomBatchSetter(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
        Classroom classroom = classrooms.get(i);
        ps.setLong(1, classroom.getId());
        ps.setString(2, classroom.getName());
        ps.setString(3, classroom.getTitle());
        ps.setString(4, classroom.getDescription());
        ps.setString(5, classroom.getLesson());
        ps.setString(6, classroom.getLocation());
        ps.setLong(7, classroom.getUniversity().getId());
    }

    @Override
    public int getBatchSize() {
        return classrooms.size();
    }
}
