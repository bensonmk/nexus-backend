package com.bmk.nexus.controller;

import com.bmk.nexus.dto.request.UserRequestDto;
import com.bmk.nexus.dto.response.UserResponseDto;
import com.bmk.nexus.entity.User;
import com.bmk.nexus.mapper.UserMapper;
import com.bmk.nexus.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto requestDto) {

        User user = userService.createUser(requestDto);

        return userMapper.toResponseDto(user);
    }
}
