package com.farzadafi.jdbctemplate.repository;

import com.farzadafi.jdbctemplate.base.repository.BaseRepository;
import com.farzadafi.jdbctemplate.entity.University;

import java.util.List;

public interface UniversityRepository extends BaseRepository<Long, University> {
    List<University> findAllWithRowMapper();
}
