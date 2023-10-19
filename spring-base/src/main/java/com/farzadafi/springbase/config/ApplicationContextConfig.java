package com.farzadafi.springbase.config;

import com.farzadafi.springbase.repository.InMemoryStudentRepository;
import com.farzadafi.springbase.repository.JdbcStudentRepository;
import com.farzadafi.springbase.repository.StudentRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ApplicationContextConfig {

    private final JdbcTemplate jdbcTemplate;

    public ApplicationContextConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    @ConditionalOnProperty(prefix = "application.configs.repository",
            name = "mode",
            havingValue = "in-memory")
    StudentRepository inMemoryStudentRepository() {
        return new InMemoryStudentRepository();
    }

    @Bean
    @ConditionalOnProperty(prefix = "application.configs.repository",
            name = "mode",
            havingValue = "jdbc")
    StudentRepository JdbcStudentRepository() {
        return new JdbcStudentRepository(jdbcTemplate);
    }

//    @Configuration
//    @EnableJpaRepositories(basePackages = "ir.maktab.springboot.repository")
//    @ConditionalOnProperty(prefix = "application.configs.repository", name = "mode", havingValue = "jpa")
//    public static class JpaConfig {
//        @Bean
//        StudentRepository jpaStudentRepository(StudentJpaRepository jpaRepository) {
//            return new JpaStudentRepository(jpaRepository);
//        }
//    }

//    @Bean
//    StudentService studentService(StudentRepository repository,
//                                  @Value("${application.configs.log.enable}") boolean isLogEnabled) {
//        StudentService studentService = new StudentServiceImpl(repository);
//        if (isLogEnabled) studentService = new LogEnabledStudentService(studentService);
//        return studentService;
//    }
}


