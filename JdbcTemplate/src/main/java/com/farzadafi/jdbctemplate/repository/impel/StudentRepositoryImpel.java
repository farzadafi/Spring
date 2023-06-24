package com.farzadafi.jdbctemplate.repository.impel;

import com.farzadafi.jdbctemplate.base.repository.BaseRepositoryImpel;
import com.farzadafi.jdbctemplate.entity.Student;
import com.farzadafi.jdbctemplate.repository.StudentRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class StudentRepositoryImpel extends BaseRepositoryImpel<Long, Student>
    implements StudentRepository {

    protected StudentRepositoryImpel(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public String getTableName() {
        return "student";
    }

    @Override
    public String getColumnsName() {
        return "(id, first_name, last_name, student_number, age, classroom_id)";
    }

    @Override
    public String getUpdateQueryParams() {
        return null;
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return "(?, ?, ?, ?, ?, ?)";
    }

    @Override
    public Student mapResultSetToEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Student entity, boolean isCountOnly) {

    }
}
