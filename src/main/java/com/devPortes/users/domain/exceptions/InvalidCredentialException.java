package com.devPortes.users.domain.exceptions;

public class InvalidCredentialException extends RuntimeException {
    public InvalidCredentialException() {
        super("Credenciales invalidas");
    }
}
