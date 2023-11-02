package com.farzadafi.springbase.config;

import com.farzadafi.springbase.message.MessageService;
import com.farzadafi.springbase.message.ResourceBundleMessageService;
import com.farzadafi.springbase.repository.*;
import com.farzadafi.springbase.service.LogEnabledStudentService;
import com.farzadafi.springbase.service.StudentService;
import com.farzadafi.springbase.service.StudentServiceImpel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ApplicationContextConfig {

    private final JdbcTemplate jdbcTemplate;
    private final MessageSource messageSource;

    public ApplicationContextConfig(JdbcTemplate jdbcTemplate, MessageSource messageSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.messageSource = messageSource;
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

    @Configuration
    @EnableJpaRepositories(basePackages = "com.farzadafi.springbase.repository")
    @ConditionalOnProperty(prefix = "application.configs.repository", name = "mode", havingValue = "jpa")
    public static class JpaConfig {
        @Bean
        StudentRepository jpaStudentRepository(StudentJpaRepository jpaRepository) {
            return new JpaStudentRepository(jpaRepository);
        }
    }

    @Bean
    public MessageService messageService() {
        return new ResourceBundleMessageService(messageSource);
    }

    @Bean
    StudentService studentService(StudentRepository repository,
                                  @Value("${application.configs.log.enable}") boolean isLogEnabled) {
        StudentService studentService = new StudentServiceImpel(repository);
        if (isLogEnabled) studentService = new LogEnabledStudentService(studentService, messageService());
        return studentService;
    }
}


