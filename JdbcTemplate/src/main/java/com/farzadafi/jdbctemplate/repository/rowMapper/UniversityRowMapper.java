package com.farzadafi.jdbctemplate.repository.rowMapper;

import com.farzadafi.jdbctemplate.entity.Classroom;
import com.farzadafi.jdbctemplate.entity.Student;
import com.farzadafi.jdbctemplate.entity.University;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UniversityRowMapper implements RowMapper<University> {

    private final JdbcTemplate jdbcTemplate;

    public UniversityRowMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public University mapRow(ResultSet rs, int rowNum) throws SQLException {
        University university = getUniversityFromResultSet(rs);
        Map<Long, Classroom> classrooms = new HashMap<>();
        jdbcTemplate.query(
                "SELECT c.id AS classroom_id, c.name AS classroom_name, c.title AS classroom_title," +
                        " c.description AS classroom_description, c.location AS classroom_location," +
                        " c.lesson AS classroom_lesson, s.id AS student_id, s.first_name AS student_first_name," +
                        " s.last_name AS student_last_name, s.student_number AS student_number," +
                        " s.age AS student_age FROM classroom c LEFT JOIN student s ON c.id = s.classroom_id WHERE c.university_id = ?",
                preparedStatement -> preparedStatement.setLong(1, university.getId()),
                rs2 -> {
                    Long classroomId = rs2.getLong("classroom_id");
                    Classroom classroom = classrooms.get(classroomId);
                    if (classroom == null) {
                        classroom = getClassroomFromResultSet(classroomId, rs2);
                        classrooms.put(classroomId, classroom);
                    }
                    Student student = getStudentFromResultSet(rs2);
                    classroom.getStudents().add(student);
                });
        university.setClassrooms(new ArrayList<>(classrooms.values()));
        return university;
    }

    private University getUniversityFromResultSet(ResultSet resultSet) throws SQLException {
        University university = new University();
        university.setId(resultSet.getLong("id"));
        university.setName(resultSet.getString("name"));
        university.setAddress(resultSet.getString("address"));
        return university;
    }

    private Classroom getClassroomFromResultSet(long classroomId, ResultSet resultSet) throws SQLException {
        Classroom classroom = Classroom.builder()
                .name(resultSet.getString("classroom_name"))
                .title(resultSet.getString("classroom_title"))
                .description(resultSet.getString("classroom_description"))
                .location(resultSet.getString("classroom_location"))
                .lesson(resultSet.getString("classroom_lesson"))
                .students(new ArrayList<>())
                .build();
        classroom.setId(classroomId);
        return classroom;
    }

    private Student getStudentFromResultSet(ResultSet resultSet) throws SQLException {
        Student student = Student.builder()
                .firstName(resultSet.getString("student_first_name"))
                .lastName(resultSet.getString("student_last_name"))
                .studentNumber(resultSet.getString("student_number"))
                .age(resultSet.getInt("student_age"))
                .build();
        student.setId(resultSet.getLong("student_id"));
        return student;
    }
}