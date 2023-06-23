package com.farzadafi.jdbctemplate.repository.impel;

import com.farzadafi.jdbctemplate.entity.base.BaseEntity;
import com.farzadafi.jdbctemplate.repository.BaseRepository;

import java.io.Serializable;
import java.sql.SQLException;

public class BaseRepositoryImpel<ID extends Serializable, TYPE extends BaseEntity<ID>>
        implements BaseRepository<ID, TYPE> {
    @Override
    public void save(TYPE entity) throws SQLException {

    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        return null;
    }
}
