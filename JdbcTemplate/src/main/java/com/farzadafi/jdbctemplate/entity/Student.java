package com.farzadafi.jdbctemplate.entity;

import com.farzadafi.jdbctemplate.base.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student extends BaseEntity<Long> {
    private String firstName;

    private String lastName;

    private String studentNumber;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    @JsonIgnore
    private Classroom classroom;
}