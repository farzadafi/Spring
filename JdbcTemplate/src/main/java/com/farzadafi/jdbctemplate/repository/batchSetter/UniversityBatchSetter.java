package com.farzadafi.jdbctemplate.repository.batchSetter;

import com.farzadafi.jdbctemplate.entity.University;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UniversityBatchSetter implements BatchPreparedStatementSetter {

    private final List<University> universities;

    public UniversityBatchSetter(List<University> universities) {
        this.universities = universities;
    }

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
        University university = universities.get(i);
        ps.setLong(1, university.getId());
        ps.setString(2, university.getName());
        ps.setString(3, university.getAddress());
    }

    @Override
    public int getBatchSize() {
        return universities.size();
    }
}
