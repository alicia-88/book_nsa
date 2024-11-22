package com.nsa.book_nsa.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // NOT FOUND ERROR 404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex, WebRequest request) {

        return buildErrorResponse(ex, HttpStatus.NOT_FOUND, request, null);
    }

    // BAD REQUEST
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentValidException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, request, errors);
    }

    // DUPLICATE
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> handleDuplicateException(DuplicateException ex, WebRequest request) {

        return buildErrorResponse(ex, HttpStatus.CONFLICT, request, null);
    }

    private ResponseEntity<?> buildErrorResponse(Exception ex, HttpStatus status, WebRequest request, Map<String, String> errors) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("message", ex.getMessage());
        body.put("errors", (errors == null ? status.getReasonPhrase() : errors));
        body.put("status", status.value());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return new ResponseEntity<>(body, new HttpHeaders(), status);
    }
}
