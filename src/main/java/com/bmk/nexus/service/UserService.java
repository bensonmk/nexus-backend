package com.bmk.nexus.service;

import com.bmk.nexus.dto.request.UserRequestDto;
import com.bmk.nexus.entity.User;
import com.bmk.nexus.exception.EmailAlreadyExistsException;
import com.bmk.nexus.mapper.UserMapper;
import com.bmk.nexus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User createUser(UserRequestDto userRequestDto) {

        User user = userMapper.toEntity(userRequestDto);

        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        return userRepository.save(user);
    }
}
