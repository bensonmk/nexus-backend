package com.bmk.nexus.controller;

import com.bmk.nexus.dto.request.UserRequestDto;
import com.bmk.nexus.dto.response.UserResponseDto;
import com.bmk.nexus.entity.User;
import com.bmk.nexus.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto user) {

        User savedUser = userService.createUser(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}
