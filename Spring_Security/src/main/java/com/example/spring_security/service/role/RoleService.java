package com.example.spring_security.service.role;


import com.example.spring_security.dto.RoleDto;
import com.example.spring_security.model.Role;

import java.util.Set;

public interface RoleService {
    Role setPermission(Role role);
    Set<String> crateSetFromRolePermissions(Role role);
    void save(Role role);
    void assignPermissionToRole(RoleDto roleDto);
}
