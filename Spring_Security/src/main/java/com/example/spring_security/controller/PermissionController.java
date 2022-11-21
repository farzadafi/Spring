package com.example.spring_security.controller;

import com.example.spring_security.dto.PermissionDto;
import com.example.spring_security.mapper.PermissionMapper;
import com.example.spring_security.model.Permission;
import com.example.spring_security.service.permission.PermissionServiceImpel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    private final PermissionServiceImpel permissionService;

    public PermissionController(PermissionServiceImpel permissionService) {
        this.permissionService = permissionService;
    }

    @PreAuthorize("hasAuthority('permission:write')")
    @PostMapping("/addPermission")
    public String addPermission(@Valid @RequestBody PermissionDto permissionDto) {
        Permission permission = PermissionMapper.INSTANCE.dtoToModel(permissionDto);
        permissionService.save(permission);
        return "OK";
    }
}
