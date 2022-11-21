package com.example.spring_security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDto {
    private Integer id;

    @NotNull
    @Pattern(regexp = "^[a-z:A-Z]{3,}$") //just Enter alphabetic
    private String name;
}
