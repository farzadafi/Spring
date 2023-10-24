package com.farzadafi.springbase.model.common;

import com.farzadafi.springbase.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonStudent implements Student {
    private Integer id;
    private String fullName;
    private String studentNumber;
}
