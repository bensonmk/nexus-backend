package com.bmk.nexus.service;

import com.bmk.nexus.dto.request.UserRequestDto;
import com.bmk.nexus.entity.User;
import com.bmk.nexus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequestDto userRequestDto) {

        User user = new User();

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());

        return userRepository.save(user);
    }
}
