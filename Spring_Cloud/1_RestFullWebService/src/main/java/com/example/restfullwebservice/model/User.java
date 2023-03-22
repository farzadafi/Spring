package com.example.restfullwebservice.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User {
    private Integer id;
    private String name;
    private LocalDateTime birthdate;
}
