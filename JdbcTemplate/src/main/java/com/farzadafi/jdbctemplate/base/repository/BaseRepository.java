package com.farzadafi.jdbctemplate.base.repository;

import com.farzadafi.jdbctemplate.base.model.BaseEntity;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<ID extends Serializable, TYPE extends BaseEntity<ID>> {
    void save(TYPE entity);

    void saveAll(BatchPreparedStatementSetter setter);

    TYPE findById(ID id);

    List<TYPE> findAll();

    void update(TYPE entity);
}
