package com.farzadafi.springbase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String fullName;
    private String studentNumber;
}
