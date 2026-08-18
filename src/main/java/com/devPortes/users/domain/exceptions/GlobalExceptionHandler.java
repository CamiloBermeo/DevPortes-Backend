package com.devPortes.users.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleFindDataBaseNotFoundException(RuntimeException exception) {
        return buildResponse(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PasswordHashInvalidException.class)
    public ResponseEntity<ErrorDetails> handleSystemErrorException(RuntimeException exception) {
        return buildResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({IdentityDocumentInvalidException.class, EmailInvalidException.class})
    public ResponseEntity<ErrorDetails> handleInvalidDataException(RuntimeException exception) {
        return buildResponse(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingUserDataBaseException.class)
    public ResponseEntity<ErrorDetails> handleFindDataBaseExistingException(RuntimeException exception) {
        return buildResponse(exception, HttpStatus.CONFLICT);
    }

    public record ErrorDetails(int status, String message) {
        public ErrorDetails(int status, String message) {
            this.status = status;
            this.message = message;
        }
    }
    private ResponseEntity<ErrorDetails> buildResponse(Exception exception, HttpStatus status) {
        ErrorDetails error = new ErrorDetails(status.value(), exception.getMessage());
        return new ResponseEntity<>(error, status);
    }
}
