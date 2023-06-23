package com.farzadafi.jdbctemplate.repository.impel;

import com.farzadafi.jdbctemplate.entity.base.BaseEntity;
import com.farzadafi.jdbctemplate.repository.BaseRepository;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseRepositoryImpel<ID extends Serializable, TYPE extends BaseEntity<ID>>
        implements BaseRepository<ID, TYPE> {
    @Override
    public void save(TYPE entity) throws SQLException {

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
