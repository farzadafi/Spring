package com.example.restfullwebservice.dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;

    @Size(min = 3, message = "Name Should have at least 3 characters")
    private String name;

    @Past(message = "Birth Date should be in the past")
    private LocalDateTime birthdate;
}
