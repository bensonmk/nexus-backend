package com.bmk.nexus.service;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String email) {
        Instant now = Instant.now();

        return JWT.create()
                .withSubject(email)
                .withExpiresAt(Date.from(now.plusMillis(expiration)))
                .withIssuedAt(Date.from(now))
                .sign(Algorithm.HMAC256(secret));
    }

    public DecodedJWT verifyToken(String token) {

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();

        return verifier.verify(token);
    }
}
