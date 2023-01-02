package com.example.spring_security.controller;

import com.example.spring_security.dto.RoleDto;
import com.example.spring_security.mapper.RoleMapper;
import com.example.spring_security.model.Role;
import com.example.spring_security.service.role.RoleServiceImpel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleServiceImpel roleService;

    public RoleController(RoleServiceImpel roleService) {
        this.roleService = roleService;
    }

    @PreAuthorize("hasAuthority('role:write')")
    @PostMapping("/addRole")
    public String addRole(@Valid @RequestBody RoleDto roleDto) {
        Role role = RoleMapper.INSTANCE.dtoToModel(roleDto);
        roleService.save(role);
        return "OK";
    }

    @PreAuthorize("hasAuthority('role:write')")
    @PostMapping("/assignPermissionToRole")
    public String assignPermissionToRole(@Valid @RequestBody RoleDto roleDto) {
        roleService.assignPermissionToRole(roleDto);
        return "OK";
    }
}
