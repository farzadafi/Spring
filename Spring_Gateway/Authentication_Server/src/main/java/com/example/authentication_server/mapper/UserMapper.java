package com.example.authentication_server.mapper;

import com.example.authentication_server.dto.UserDto;
import com.example.authentication_server.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToModel(UserDto userDto);
}
