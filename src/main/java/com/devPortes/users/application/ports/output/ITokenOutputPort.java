package com.devPortes.users.application.ports.output;

import com.devPortes.users.infrastructure.input.security.CustomUserDetails;

public interface ITokenOutputPort {
    String generateNewToken (CustomUserDetails customUserDetails);
    String getSubject(String token);
}
