package com.farzadafi.jdbctemplate.service.impel;

import com.farzadafi.jdbctemplate.base.service.BaseServiceImpel;
import com.farzadafi.jdbctemplate.entity.Classroom;
import com.farzadafi.jdbctemplate.entity.University;
import com.farzadafi.jdbctemplate.repository.ClassroomRepository;
import com.farzadafi.jdbctemplate.repository.batchSetter.ClassroomBatchSetter;
import com.farzadafi.jdbctemplate.service.ClassroomService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class ClassroomServiceImpel extends BaseServiceImpel<Long, Classroom, ClassroomRepository>
    implements ClassroomService {

    public ClassroomServiceImpel(ClassroomRepository repository) {
        super(repository);
    }

    //todo fix it
    @Override
    public void createAndInsert() throws SQLException {
        long counter = 1;
        for (int j = 1; j <= 10; j++) {
            ArrayList<Classroom> classrooms = new ArrayList<>();
//            University university = universityService.getById((long) j);
            University university = new University();
            university.setId((long) j);
            for (int i = 1; i <= 10000; i++) { // 10000 - 10
                Classroom classroom = Classroom.builder()
                        .name("classroom " + i)
                        .title("title " + i)
                        .description("description " + i)
                        .lesson("lesson " + i)
                        .location("location " + i)
                        .university(university)
                        .build();
                classroom.setId(counter);
                classrooms.add(classroom);
                ++counter;
            }
            saveAll(new ClassroomBatchSetter(classrooms));
        }
    }
}
