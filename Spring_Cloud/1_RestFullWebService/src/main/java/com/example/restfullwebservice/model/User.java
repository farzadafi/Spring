package com.example.restfullwebservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("user_name")
    private String name;
    private LocalDateTime birthdate;
}
