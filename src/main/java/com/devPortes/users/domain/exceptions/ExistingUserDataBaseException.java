package com.devPortes.users.domain.exceptions;

public class ExistingUserDataBaseException extends RuntimeException {
    public ExistingUserDataBaseException(String email) {
        super("El usuario "+email+" ya se encuentra registrado.");
    }
}
