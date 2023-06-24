package com.farzadafi.jdbctemplate.repository.impel;

import com.farzadafi.jdbctemplate.base.repository.BaseRepositoryImpel;
import com.farzadafi.jdbctemplate.entity.Classroom;
import com.farzadafi.jdbctemplate.repository.ClassroomRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassroomRepositoryImpel extends BaseRepositoryImpel<Long, Classroom>
    implements ClassroomRepository {

    protected ClassroomRepositoryImpel(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getColumnsName() {
        return null;
    }

    @Override
    public String getUpdateQueryParams() {
        return null;
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return null;
    }

    @Override
    public Classroom mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Classroom entity, boolean isCountOnly) {

    }
}
