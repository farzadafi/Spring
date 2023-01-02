package com.example.spring_unittest.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Integer id;

    private String username;

    private String password;
}
