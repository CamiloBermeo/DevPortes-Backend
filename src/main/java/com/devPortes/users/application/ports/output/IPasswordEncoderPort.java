package com.devPortes.users.application.ports.output;

public interface IPasswordEncoderPort {

    String encodePassword (String commandPassword);
    boolean matchesPasswords (String passwordPlane, String saveHashPassword);
}
