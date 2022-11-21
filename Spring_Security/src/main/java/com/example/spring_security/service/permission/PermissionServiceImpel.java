package com.example.spring_security.service.permission;

import com.example.spring_security.exception.FailSaveException;
import com.example.spring_security.model.Permission;
import com.example.spring_security.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PermissionServiceImpel implements PermissionService{

    private final PermissionRepository repository;

    public PermissionServiceImpel(PermissionRepository permissionRepository) {
        this.repository = permissionRepository;
    }

    @Override
    public Optional<Permission> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void save(Permission permission) {
        if (repository.save(permission).getId() == null)
            throw new FailSaveException("Unfortunately save " + permission.getName());
    }

    @Override
    public Set<Permission> findPermissions(Set<String> permissionNameSets) {
        Set<Permission> permissions = new HashSet<>();
        permissionNameSets
                .forEach(s -> findByName(s)
                        .ifPresent(permissions::add));
        return permissions;
    }
}
