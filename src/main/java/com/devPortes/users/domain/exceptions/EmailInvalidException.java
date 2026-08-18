package com.devPortes.users.domain.exceptions;

public class EmailInvalidException extends RuntimeException {
    public EmailInvalidException(String email) {
        super("El email ingresado "+email+" es invalido debe contener '@' y/o '.com'");
    }
}
