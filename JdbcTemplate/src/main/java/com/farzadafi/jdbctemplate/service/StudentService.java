package com.farzadafi.jdbctemplate.service;

import com.farzadafi.jdbctemplate.base.service.BaseService;
import com.farzadafi.jdbctemplate.entity.Student;

import java.sql.SQLException;

public interface StudentService extends BaseService<Long, Student> {
    void createAndInsert() throws SQLException;
}
