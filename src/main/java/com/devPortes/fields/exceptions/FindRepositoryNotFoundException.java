package com.devPortes.fields.exceptions;

public class FindRepositoryNotFoundException extends RuntimeException{
     public FindRepositoryNotFoundException(Long id) {
        super("Location " + id + " existía en application pero no al persistir");
    }

}
