package com.relgs.product.infra;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    private static final String TIMESTAMP = "timestamp";
    private static final String STATUS = "status";
    private static final String ERROR = "error";
    private static final String MESSAGE = "message";

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Map<String, Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(TIMESTAMP, LocalDateTime.now());
        response.put(STATUS, HttpStatus.NOT_FOUND.value());
        response.put(ERROR, "Not Found");
        response.put(MESSAGE, ex.getMessage());
        return response;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> handleValidationException(ValidationException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(TIMESTAMP, LocalDateTime.now());
        response.put(STATUS, HttpStatus.BAD_REQUEST.value());
        response.put(ERROR, "Bad Request");
        response.put(MESSAGE, ex.getMessage());
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handleGlobalException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(TIMESTAMP, LocalDateTime.now());
        response.put(STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put(ERROR, "Internal Server Error");
        response.put(MESSAGE, "An unexpected error occurred.");
        return response;
    }
}

