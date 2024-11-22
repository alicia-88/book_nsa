package com.nsa.book_nsa.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message, Long id) {
        super("Could not find " + id + " for " + message);
    }
}
