package com.example.spring_security.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Permission extends Base<Integer> {

    @Column(unique = true)
    private String name;
}
