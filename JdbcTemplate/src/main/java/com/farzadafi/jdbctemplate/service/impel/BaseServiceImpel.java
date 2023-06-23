package com.farzadafi.jdbctemplate.service.impel;

import com.farzadafi.jdbctemplate.entity.base.BaseEntity;
import com.farzadafi.jdbctemplate.repository.BaseRepository;
import com.farzadafi.jdbctemplate.service.BaseService;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

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
    public void saveAll(List<TYPE> entities) throws SQLException {
        repository.saveAll(entities);
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
