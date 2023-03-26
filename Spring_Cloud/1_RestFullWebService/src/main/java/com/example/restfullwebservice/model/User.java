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
//@JsonIgnoreProperties("user_name") //static filter
//@JsonFilter("userFilter") //dynamic filter
public class User {
    private Integer id;

    @JsonProperty("user_name")
    //@JsonIgnore
    private String name;
    private LocalDateTime birthdate;
}
