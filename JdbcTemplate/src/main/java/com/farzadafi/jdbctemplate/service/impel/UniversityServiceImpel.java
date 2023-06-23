package com.farzadafi.jdbctemplate.service.impel;

import com.farzadafi.jdbctemplate.base.service.BaseServiceImpel;
import com.farzadafi.jdbctemplate.entity.University;
import com.farzadafi.jdbctemplate.repository.UniversityRepository;
import com.farzadafi.jdbctemplate.repository.batchSetter.UniversityBatchSetter;
import com.farzadafi.jdbctemplate.service.UniversityService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityServiceImpel extends BaseServiceImpel<Long, University, UniversityRepository>
        implements UniversityService {

    public UniversityServiceImpel(UniversityRepository repository) {
        super(repository);
    }

    public void insertData() throws SQLException {
        List<University> universities = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            University university = University.builder()
                    .name("university" + i)
                    .address("location " + i).build();
            university.setId((long) i);
            universities.add(university);
        }
        saveAll(universities, new UniversityBatchSetter(universities));
    }
}
