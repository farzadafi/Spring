package com.example.spring_security.mapper;

import com.example.spring_security.dto.PermissionDto;
import com.example.spring_security.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionMapper {

    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);

    Permission dtoToModel(PermissionDto permissionDto);
}
