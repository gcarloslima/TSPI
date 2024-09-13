package com.relgs.product.infra;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
