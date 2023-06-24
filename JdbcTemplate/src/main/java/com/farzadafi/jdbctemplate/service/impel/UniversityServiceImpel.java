package com.farzadafi.jdbctemplate.service.impel;

import com.farzadafi.jdbctemplate.base.service.BaseServiceImpel;
import com.farzadafi.jdbctemplate.entity.University;
import com.farzadafi.jdbctemplate.repository.UniversityRepository;
import com.farzadafi.jdbctemplate.repository.batchSetter.UniversityBatchSetter;
import com.farzadafi.jdbctemplate.service.UniversityService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityServiceImpel extends BaseServiceImpel<Long, University, UniversityRepository>
        implements UniversityService {

    private final ObjectMapper objectMapper;

    public UniversityServiceImpel(UniversityRepository repository, ObjectMapper objectMapper) {
        super(repository);
        this.objectMapper = objectMapper;
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
        saveAll(new UniversityBatchSetter(universities));
    }

    @Override
    public void fetchAndSaveInFile() throws IOException {
        JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(new FileWriter("universities.json"));
        jsonGenerator.writeStartArray();
        List<University> allUniversity = repository.findAllWithRowMapper();
        for (University record : allUniversity) {
            objectMapper.writeValue(jsonGenerator, record);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.flush();
        jsonGenerator.close();
    }
}
