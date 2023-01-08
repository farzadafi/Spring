package com.example.authentication_server.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    Integer id;

    String fullName;

    @Column(unique = true)
    String username;

    String password;
}
