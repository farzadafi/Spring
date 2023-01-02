package com.example.spring_security.mapper;

import com.example.spring_security.dto.RoleDto;
import com.example.spring_security.model.Permission;
import com.example.spring_security.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Named("dtoToModel")
    default Role dtoToModel(RoleDto roleDto) {
        Role role = Role.builder().name(roleDto.getName()).isEnabled(false).build();
        Set<Permission> permissions = new HashSet<>();
        roleDto.getPermissions()
                .forEach(s -> permissions
                        .add(new Permission(s)));
        role.setPermissions(permissions);
        return role;
    }
}
