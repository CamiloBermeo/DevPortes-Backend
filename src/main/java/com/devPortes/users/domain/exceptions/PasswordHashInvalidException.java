package com.devPortes.users.domain.exceptions;

public class PasswordHashInvalidException extends RuntimeException {
    public PasswordHashInvalidException() {
        super("El sistema ha fallado al encriptar la contraseña");
    }
}
