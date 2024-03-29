package com.farzadafi.jdbctemplate.base.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity <ID extends Serializable>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected ID id;
}