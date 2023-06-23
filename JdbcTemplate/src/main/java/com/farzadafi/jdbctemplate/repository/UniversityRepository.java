package com.farzadafi.jdbctemplate.repository;

import com.farzadafi.jdbctemplate.base.repository.BaseRepository;
import com.farzadafi.jdbctemplate.entity.University;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends BaseRepository<Integer, University> {
}
