package com.example.spring_security.service.permission;


import com.example.spring_security.model.Permission;

import java.util.Optional;
import java.util.Set;

public interface PermissionService {
    Optional<Permission> findByName(String name);
    void save(Permission permission);
    Set<Permission> findPermissions(Set<String> permissionNameSets);
}
