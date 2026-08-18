package com.devPortes.configuration.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
@RequiredArgsConstructor
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret ;

    public String generateToken(CustomUserDetails customUserDetails){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("devportes")
                .withSubject(customUserDetails.getUsername())
                .withExpiresAt(expirationDate())
                .sign(algorithm);

    }

    private Instant expirationDate(){
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.systemDefault().getRules().getOffset(LocalDateTime.now()));
    }
}
