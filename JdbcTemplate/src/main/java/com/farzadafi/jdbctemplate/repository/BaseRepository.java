package com.farzadafi.jdbctemplate.repository;

import com.farzadafi.jdbctemplate.entity.base.BaseEntity;

import java.io.Serializable;
import java.sql.SQLException;

public interface BaseRepository<ID extends Serializable, TYPE extends BaseEntity<ID>> {
    void save(TYPE entity) throws SQLException;

    TYPE findById(ID id) throws SQLException;
}
