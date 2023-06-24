package com.farzadafi.jdbctemplate.service.impel;

import com.farzadafi.jdbctemplate.base.service.BaseServiceImpel;
import com.farzadafi.jdbctemplate.entity.Classroom;
import com.farzadafi.jdbctemplate.entity.Student;
import com.farzadafi.jdbctemplate.repository.StudentRepository;
import com.farzadafi.jdbctemplate.repository.batchSetter.StudentBatchSetter;
import com.farzadafi.jdbctemplate.service.StudentService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class StudentServiceImpel extends BaseServiceImpel<Long, Student, StudentRepository>
    implements StudentService {

    public StudentServiceImpel(StudentRepository repository) {
        super(repository);
    }

    // todo fix classroom
    @Override
    public void createAndInsert() throws SQLException {
        long counter = 1;
        for (int i = 1; i < 100000; i++) { // 100000 - 10
            ArrayList<Student> students = new ArrayList<>();
//            Classroom classroom = classroomService.getById((long) i);
            Classroom classroom = new Classroom();
            classroom.setId((long) i);
            for (int j = 1; j <= 10; j++) { // 10 - 3
                Student student = Student.builder()
                        .firstName("student firstname " + j)
                        .lastName("student lastname " + j)
                        .studentNumber(String.valueOf(j * 11111111))
                        .age(j * 10)
                        .classroom(classroom)
                        .build();
                student.setId(counter);
                students.add(student);
                ++counter;
            }
            saveAll(new StudentBatchSetter(students));
        }
    }
}
