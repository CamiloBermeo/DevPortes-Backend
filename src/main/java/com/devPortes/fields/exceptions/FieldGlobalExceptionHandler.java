package com.devPortes.fields.exceptions;

import com.devPortes.configuration.BaseExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FieldGlobalExceptionHandler extends BaseExceptionHandler {

    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<ErrorDetails> handleExternalServiceException(RuntimeException ex) {
        return buildResponse(ex, HttpStatus.BAD_GATEWAY);
    }

}
