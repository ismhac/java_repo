package com.example.demo_01.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo_01.dtos.UserDto;
import com.example.demo_01.entities.User;
import com.example.demo_01.exceptions.NotFoundException;
import com.example.demo_01.mapstruct.UserMapper;
import com.example.demo_01.repositories.UserRepository;
import com.example.demo_01.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(UserDto userDto) {
        // User user = new User();
        // user.setFirstName(userDto.getFirstName());
        // user.setLastName(userDto.getLastName());
        // user.setEmail(userDto.getEmail());
        // user.setPassword(userDto.getPassword());
        // userRepository.save(user);
        User user = userMapper.dtoToEntity(userDto);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getListUsers() {
        List<User> listUsers = userRepository.findAll();
        return listUsers;
    }

    @Override
    public User updateUser(Long id, UserDto userDto) throws NotFoundException {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found user"));
        userMapper.updateFields(user, userDto);
        userRepository.save(user);
        return user;
    }

    @Override
    public String deleteUser(Long id) throws NotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found user"));
        userRepository.delete(user);
        return "Delete user successfully";
    }
}
