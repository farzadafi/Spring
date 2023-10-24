package com.farzadafi.springbase.model.jpa;

import com.farzadafi.springbase.model.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity implements Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String studentNumber;

    public StudentEntity(Student student) {
        this.id = student.getId();
        this.fullName = student.getFullName();
        this.studentNumber = student.getStudentNumber();
    }
}
