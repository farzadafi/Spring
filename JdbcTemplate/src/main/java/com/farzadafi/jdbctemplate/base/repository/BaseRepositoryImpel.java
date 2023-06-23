package com.farzadafi.jdbctemplate.base.repository;

import com.farzadafi.jdbctemplate.base.model.BaseEntity;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public abstract class BaseRepositoryImpel<ID extends Serializable, TYPE extends BaseEntity<ID>>
        implements BaseRepository<ID, TYPE> {

    private final JdbcTemplate jdbcTemplate;

    protected BaseRepositoryImpel(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(TYPE entity) throws SQLException {

    }

    @Override
    public void saveAll(List<TYPE> entities, BatchPreparedStatementSetter setter) throws SQLException {
        String sql = "INSERT INTO " + getTableName() + " " + getColumnsName() + " VALUES " + getCountOfQuestionMarkForParams() + "";
        jdbcTemplate.batchUpdate(sql, setter);
    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        return null;
    }

    @Override
    public List<TYPE> findAll() throws SQLException {
        return null;
    }

    @Override
    public void update(TYPE entity) throws SQLException {

    }

    public abstract String getTableName();

    public abstract String getColumnsName();

    public abstract String getUpdateQueryParams();

    public abstract String getCountOfQuestionMarkForParams();

    public abstract TYPE mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public abstract void fillParamForStatement(PreparedStatement preparedStatement,
                                               TYPE entity,
                                               boolean isCountOnly);
}
