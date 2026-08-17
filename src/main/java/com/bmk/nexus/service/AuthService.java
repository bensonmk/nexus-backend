package com.bmk.nexus.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.bmk.nexus.dto.request.LoginRequestDto;
import com.bmk.nexus.dto.response.LoginResponseDto;
import com.bmk.nexus.entity.User;
import com.bmk.nexus.exception.InvalidCredentialsException;
import com.bmk.nexus.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDto login(LoginRequestDto requestDto) {

        User user = userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid email or password."));

        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }

        String token = jwtService.generateToken(requestDto.getEmail());

        DecodedJWT decodedJWT = jwtService.verifyToken(token);

        System.out.println(decodedJWT.getSubject());

        return new LoginResponseDto(token);
    }
}
