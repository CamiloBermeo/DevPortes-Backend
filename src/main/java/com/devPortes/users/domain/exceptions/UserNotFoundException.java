package com.devPortes.users.domain.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super("El usuario "+ email + "No se encuentra registrado en la base de datos");
    }
}
