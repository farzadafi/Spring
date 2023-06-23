package com.farzadafi.jdbctemplate.base.repository;

import com.farzadafi.jdbctemplate.base.model.BaseEntity;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface BaseRepository<ID extends Serializable, TYPE extends BaseEntity<ID>> {
    void save(TYPE entity) throws SQLException;

    void saveAll(List<TYPE> entities, BatchPreparedStatementSetter setter) throws SQLException;

    TYPE findById(ID id) throws SQLException;

    List<TYPE> findAll() throws SQLException;

    void update(TYPE entity) throws SQLException;
}
