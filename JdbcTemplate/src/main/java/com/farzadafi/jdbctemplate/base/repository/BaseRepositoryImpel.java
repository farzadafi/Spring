package com.farzadafi.jdbctemplate.base.repository;

import com.farzadafi.jdbctemplate.base.model.BaseEntity;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepositoryImpel<ID extends Serializable, TYPE extends BaseEntity<ID>>
        implements BaseRepository<ID, TYPE> {

    private final JdbcTemplate jdbcTemplate;

    protected BaseRepositoryImpel(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(TYPE entity) {

    }

    @Override
    public void saveAll(BatchPreparedStatementSetter setter) {
        String sql = "INSERT INTO " + getTableName() + " " + getColumnsName() + " VALUES " + getCountOfQuestionMarkForParams() + "";
        jdbcTemplate.batchUpdate(sql, setter);
    }

    @Override
    public TYPE findById(ID id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE id=?";
        PreparedStatementSetter preparedStatementSetter = (preparedStatement) -> {
            preparedStatement.setLong(1, (long) id);
        };
        ResultSetExtractor<TYPE> resultSetExtractor = (resultSet) -> {
            if (resultSet.next()) {
                return mapResultSetToEntity(resultSet);
            } else
                return null;
        };
        return jdbcTemplate.query(sql, preparedStatementSetter, resultSetExtractor);
    }

    @Override
    public List<TYPE> findAll() {
        String sql = " SELECT * FROM " + getTableName();
        PreparedStatementSetter preparedStatementSetter = (preparedStatement) -> {};
        List<TYPE> entities = new ArrayList<>();
        ResultSetExtractor<List<TYPE>> resultSetExtractor = (resultSet) -> {
            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
            return entities;
        };
        return jdbcTemplate.query(sql, preparedStatementSetter, resultSetExtractor);
    }

    @Override
    public void update(TYPE entity) {

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
