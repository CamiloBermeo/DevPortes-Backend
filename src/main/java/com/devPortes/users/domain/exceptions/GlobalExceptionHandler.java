package com.devPortes.users.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleFindDataBaseNotFoundException(RuntimeException exception) {
        return buildResponse(exception, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<ErrorDetails> handleCredentialException(RuntimeException exception) {
        return buildResponse(exception, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDetails> handleValidation(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        List<String> errors = fieldErrorList.stream().map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        return buildValidationResponse(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordHashInvalidException.class)
    public ResponseEntity<ErrorDetails> handleSystemErrorException(RuntimeException exception) {
        return buildResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({IdentityDocumentInvalidException.class, EmailInvalidException.class,})
    public ResponseEntity<ErrorDetails> handleInvalidDataException(RuntimeException exception) {
        return buildResponse(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingUserDataBaseException.class)
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
