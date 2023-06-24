package com.farzadafi.jdbctemplate;

import com.farzadafi.jdbctemplate.service.impel.ClassroomServiceImpel;
import com.farzadafi.jdbctemplate.service.impel.StudentServiceImpel;
import com.farzadafi.jdbctemplate.service.impel.UniversityServiceImpel;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class JdbcTemplateApplication {

    private final UniversityServiceImpel universityServiceImpel;
    private final ClassroomServiceImpel classroomServiceImpel;
    private final StudentServiceImpel studentServiceImpel;

    public JdbcTemplateApplication(UniversityServiceImpel universityServiceImpel, ClassroomServiceImpel classroomServiceImpel, StudentServiceImpel studentServiceImpel) {
        this.universityServiceImpel = universityServiceImpel;
        this.classroomServiceImpel = classroomServiceImpel;
        this.studentServiceImpel = studentServiceImpel;
    }


    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateApplication.class, args);
    }

    @PostConstruct
    public void insertDataAndFetchToFile() throws SQLException, IOException {
        if (universityServiceImpel.findById(1L) == null) {
            universityServiceImpel.insertData();
            classroomServiceImpel.createAndInsert();
            studentServiceImpel.createAndInsert();
        }
        universityServiceImpel.fetchAndSaveInFile();
    }
}
