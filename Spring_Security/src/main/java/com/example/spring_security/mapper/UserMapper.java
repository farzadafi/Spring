package com.example.spring_security.mapper;

import com.example.spring_security.dto.UserDto;
import com.example.spring_security.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToModel(UserDto userDto);
}
