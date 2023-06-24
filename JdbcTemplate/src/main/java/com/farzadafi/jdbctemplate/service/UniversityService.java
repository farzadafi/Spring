package com.farzadafi.jdbctemplate.service;

import com.farzadafi.jdbctemplate.base.service.BaseService;
import com.farzadafi.jdbctemplate.entity.University;

import java.io.IOException;
import java.sql.SQLException;

public interface UniversityService extends BaseService<Long, University> {
    void insertData() throws SQLException;
    void fetchAndSaveInFile() throws IOException;
}
