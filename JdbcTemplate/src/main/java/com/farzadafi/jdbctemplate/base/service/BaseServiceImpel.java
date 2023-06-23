package com.farzadafi.jdbctemplate.base.service;

import com.farzadafi.jdbctemplate.base.model.BaseEntity;
import com.farzadafi.jdbctemplate.base.repository.BaseRepository;
import com.farzadafi.jdbctemplate.base.service.BaseService;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Service
public class BaseServiceImpel<ID extends Serializable, TYPE extends BaseEntity<ID>,
        R extends BaseRepository<ID, TYPE>>
        implements BaseService<ID, TYPE> {

    protected final R repository;

    public BaseServiceImpel(R repository) {
        this.repository = repository;
    }

    @Override
    public void save(TYPE entity) throws SQLException {
        repository.save(entity);
    }

    @Override
    public void saveAll(List<TYPE> entities, BatchPreparedStatementSetter setter) throws SQLException {
        repository.saveAll(entities, setter);
    }

    @Override
    public List<TYPE> findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        return repository.findById(id);
    }

    @Override
    public void update(TYPE entity) throws SQLException {
        repository.update(entity);
    }
}
