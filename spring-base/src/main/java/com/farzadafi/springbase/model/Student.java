package com.farzadafi.springbase.model;

public interface Student {
    void setId(Integer id);
    Integer getId();

    void setFullName(String fullName);
    String getFullName();

    void setStudentNumber(String studentNumber);
    String getStudentNumber();
}
