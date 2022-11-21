package com.example.spring_security.service.role;

import com.example.spring_security.dto.RoleDto;
import com.example.spring_security.exception.FailSaveException;
import com.example.spring_security.exception.PermissionNotFoundException;
import com.example.spring_security.exception.RoleNotFoundException;
import com.example.spring_security.model.Permission;
import com.example.spring_security.model.Role;
import com.example.spring_security.repository.RoleRepository;
import com.example.spring_security.service.permission.PermissionServiceImpel;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpel implements RoleService {

    private final PermissionServiceImpel permissionService;
    private final RoleRepository repository;

    public RoleServiceImpel(PermissionServiceImpel permissionService, RoleRepository repository) {
        this.permissionService = permissionService;
        this.repository = repository;
    }

    @Override
    public Role setPermission(Role role) {
        Set<String> permissionNameSets = crateSetFromRolePermissions(role);
        Set<Permission> permissions = permissionService.findPermissions(permissionNameSets);

        if(!permissions.isEmpty()) {
            role.setPermissions(permissions);
            role.setEnabled(true);
        } else {
            role.setPermissions(Sets.newHashSet());
        }
        return role;
    }

    @Override
    public Set<String> crateSetFromRolePermissions(Role role) {
        return role.getPermissions()
                .stream()
                .map(Permission::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public void save(Role role) {
        if ( !role.getPermissions().isEmpty() )
            role = setPermission(role);

        if (repository.save(role).getId() == null)
            throw new FailSaveException("Unfortunately save " + role.getName());
    }

    @Override
    public void assignPermissionToRole(RoleDto roleDto) {
        Role role = repository.findByName(roleDto.getName())
                .orElseThrow(() -> new RoleNotFoundException( roleDto.getName() + "unfortunately not Found!"));
        Role roleWithPermission = setPermission(role);
        if(roleWithPermission.getPermissions().isEmpty())
            throw new PermissionNotFoundException("Any Valid Permission NotFound!");
        repository.save(roleWithPermission);
    }
}
