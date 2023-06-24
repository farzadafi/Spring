package com.farzadafi.jdbctemplate.entity;

import com.farzadafi.jdbctemplate.base.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Classroom extends BaseEntity<Long> {
    private String name;

    private String title;

    private String description;

    private String location;

    private String lesson;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id")
    @JsonIgnore
    private University university;

    @OneToMany(mappedBy = "classroom")
    private ArrayList<Student> students;
}