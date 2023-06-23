package com.farzadafi.jdbctemplate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;

    private String studentNumber;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    @JsonIgnore
    private Classroom classroom;
}