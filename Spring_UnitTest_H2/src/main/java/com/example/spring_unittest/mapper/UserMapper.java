package com.example.spring_unittest.mapper;

import com.example.spring_unittest.dto.UserDto;
import com.example.spring_unittest.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToModel(UserDto userDto);
}
