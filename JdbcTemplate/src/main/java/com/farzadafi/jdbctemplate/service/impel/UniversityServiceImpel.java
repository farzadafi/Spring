package com.farzadafi.jdbctemplate.service.impel;

import com.farzadafi.jdbctemplate.base.service.BaseServiceImpel;
import com.farzadafi.jdbctemplate.entity.University;
import com.farzadafi.jdbctemplate.repository.UniversityRepository;
import com.farzadafi.jdbctemplate.service.UniversityService;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpel extends BaseServiceImpel<Integer, University, UniversityRepository>
        implements UniversityService {

    public UniversityServiceImpel(UniversityRepository repository) {
        super(repository);
    }
}
