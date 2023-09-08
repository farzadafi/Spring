package com.farzadafi.authserver.model;

import com.farzadafi.authserver.model.enumeration.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "full_name")
    String fullName;

    @Column(unique = true)
    String username;

    String password;

    @Enumerated(EnumType.STRING)
    Role role;
}