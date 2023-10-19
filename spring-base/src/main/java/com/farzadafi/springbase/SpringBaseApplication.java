package com.farzadafi.springbase;

import com.farzadafi.springbase.model.Student;
import com.farzadafi.springbase.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBaseApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (StudentService studentService){
        return args -> studentService.register(new Student(null, null, null));
    }
}
