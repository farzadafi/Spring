package com.farzadafi.jdbctemplate.repository.impel;

import com.farzadafi.jdbctemplate.base.repository.BaseRepositoryImpel;
import com.farzadafi.jdbctemplate.entity.University;
import com.farzadafi.jdbctemplate.repository.UniversityRepository;
import com.farzadafi.jdbctemplate.repository.rowMapper.UniversityRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class UniversityRepositoryImpel extends BaseRepositoryImpel<Long, University> implements UniversityRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UniversityRowMapper universityRowMapper;

    protected UniversityRepositoryImpel(JdbcTemplate jdbcTemplate, UniversityRowMapper universityRowMapper) {
        super(jdbcTemplate);
        this.jdbcTemplate = jdbcTemplate;
        this.universityRowMapper = universityRowMapper;
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
    public University mapResultSetToEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, University entity, boolean isCountOnly) {

    }

    @Override
    public List<University> findAllWithRowMapper() {
        String sql = "SELECT * FROM university";
        return jdbcTemplate.query(sql, universityRowMapper);
    }
}
