package com.devPortes.location.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExistingLocationDataBaseException.class)
    public ResponseEntity<ErrorDetails> handleFindDataBaseExistingException(RuntimeException exception) {
        return buildResponse(exception, HttpStatus.CONFLICT);
    }


    public record ValidationErrorDetails(int status, List<String> messages) {
        public ValidationErrorDetails(int status, List<String> messages) {
            this.status = status;
            this.messages = messages;
        }
    }

    private ResponseEntity<ValidationErrorDetails> buildValidationResponse(List<String> exceptions, HttpStatus status) {
        ValidationErrorDetails error = new ValidationErrorDetails(status.value(), exceptions);
        return new ResponseEntity<>(error, status);
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
