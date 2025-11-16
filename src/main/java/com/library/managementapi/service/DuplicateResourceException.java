package com.library.managementapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// When this Exception is thrown, Spring will respond with a 409 CONFLICT status.
@ResponseStatus(HttpStatus.CONFLICT) 
public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String message) {
        super(message);
    }
}