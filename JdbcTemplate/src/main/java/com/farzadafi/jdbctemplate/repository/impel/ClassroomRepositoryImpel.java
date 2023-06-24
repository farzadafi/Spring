package com.farzadafi.jdbctemplate.repository.impel;

import com.farzadafi.jdbctemplate.base.repository.BaseRepositoryImpel;
import com.farzadafi.jdbctemplate.entity.Classroom;
import com.farzadafi.jdbctemplate.repository.ClassroomRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class ClassroomRepositoryImpel extends BaseRepositoryImpel<Long, Classroom>
    implements ClassroomRepository {

    protected ClassroomRepositoryImpel(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public String getTableName() {
        return "classroom";
    }

    @Override
    public String getColumnsName() {
        return "(id, name, title, description, location, lesson, university_id)";
    }

    @Override
    public String getUpdateQueryParams() {
        return null;
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return "(?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public Classroom mapResultSetToEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Classroom entity, boolean isCountOnly) {

    }
}
