package com.farzadafi.jdbctemplate.repository.impel;

import com.farzadafi.jdbctemplate.base.repository.BaseRepositoryImpel;
import com.farzadafi.jdbctemplate.entity.University;
import com.farzadafi.jdbctemplate.repository.UniversityRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UniversityRepositoryImpel extends BaseRepositoryImpel<Long, University> implements UniversityRepository {
    protected UniversityRepositoryImpel(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public String getTableName() {
        return "university";
    }

    @Override
    public String getColumnsName() {
        return "(id, name, address)";
    }

    @Override
    public String getUpdateQueryParams() {
        return "";
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return "(?, ?, ?)";
    }

    @Override
    public University mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, University entity, boolean isCountOnly) {

    }
}
