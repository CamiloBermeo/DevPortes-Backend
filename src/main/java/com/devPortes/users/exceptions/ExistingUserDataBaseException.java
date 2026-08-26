package com.devPortes.users.exceptions;

public class ExistingUserDataBaseException extends RuntimeException {
    public ExistingUserDataBaseException(String email) {
        super("El usuario "+email+" ya se encuentra registrado.");
    }
}
