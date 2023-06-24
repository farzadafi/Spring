package com.farzadafi.jdbctemplate.service;

import com.farzadafi.jdbctemplate.base.service.BaseService;
import com.farzadafi.jdbctemplate.entity.Classroom;

import java.sql.SQLException;

public interface ClassroomService extends BaseService<Long, Classroom> {
    void createAndInsert() throws SQLException;
}
