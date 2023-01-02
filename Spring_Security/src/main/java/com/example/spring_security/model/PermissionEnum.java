package com.example.spring_security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PermissionEnum {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;
}