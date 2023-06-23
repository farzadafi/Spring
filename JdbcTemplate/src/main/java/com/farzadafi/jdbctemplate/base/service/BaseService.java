package com.farzadafi.jdbctemplate.base.service;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.SQLException;
import java.util.List;

public interface BaseService <ID,TYPE>{

    void save(TYPE entity) throws SQLException;

    void saveAll(List<TYPE> entities, BatchPreparedStatementSetter setter) throws SQLException;

    List<TYPE> findAll() throws SQLException;

    TYPE findById(ID id) throws SQLException;

    void update(TYPE entity) throws SQLException;
}
