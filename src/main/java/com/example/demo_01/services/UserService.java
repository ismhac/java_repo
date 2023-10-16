package com.example.demo_01.services;

import java.util.List;

import com.example.demo_01.dtos.UserDto;
import com.example.demo_01.entities.User;
import com.example.demo_01.exceptions.NotFoundException;

public interface UserService {
    User createUser(UserDto userDto);

    User updateUser(Long id, UserDto userDto) throws NotFoundException;

    List<User> getListUsers();

    String deleteUser(Long id) throws NotFoundException;
}
