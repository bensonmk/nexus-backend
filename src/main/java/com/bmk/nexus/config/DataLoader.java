package com.bmk.nexus.config;

import com.bmk.nexus.entity.User;
import com.bmk.nexus.repository.UserRepository;
import com.bmk.nexus.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {

        User user = new User();

        user.setName("BMK");
        user.setEmail("bmk@gmail.com");
        user.setPassword("12345566");

//        userService.createUser(user);

        System.out.println("User Saved!");

    }
}
