package com.farzadafi.jdbctemplate.entity;

import com.farzadafi.jdbctemplate.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class University extends BaseEntity<Long> {

    private String name;

    private String address;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Classroom> classrooms;

    public University(long id, String name, String address, List<Classroom> classrooms) {
        super(id);
        this.name = name;
        this.address = address;
        this.classrooms = classrooms;
    }
}
