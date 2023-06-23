package com.farzadafi.jdbctemplate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Classroom> classrooms;
}
