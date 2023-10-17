package com.example.demo_01.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import org.mapstruct.factory.Mappers;

import com.example.demo_01.dtos.UserDto;

import com.example.demo_01.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper instance = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User dtoToEntity(UserDto userDto);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateFields(@MappingTarget User user, UserDto userDto);
}
