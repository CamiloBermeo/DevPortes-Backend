package com.devPortes.users.infrastructure.input.security;

import com.devPortes.users.application.ports.output.IPasswordEncoderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BCryptPasswordEncodeAdapter implements IPasswordEncoderPort {
    private final PasswordEncoder  encoder;

    @Override
    public String encodePassword(String commandPassword) {
        return encoder.encode(commandPassword);
    }

    @Override
    public boolean matchesPasswords(String passwordPlane, String saveHashPassword) {
        return encoder.matches(passwordPlane, saveHashPassword);
    }
}
