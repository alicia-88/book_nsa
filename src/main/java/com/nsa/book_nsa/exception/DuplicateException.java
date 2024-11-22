package com.nsa.book_nsa.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class DuplicateException extends RuntimeException {
    public DuplicateException(String message, Long id) {
        super("duplicate id " + id + ": " + message);
    }
}
