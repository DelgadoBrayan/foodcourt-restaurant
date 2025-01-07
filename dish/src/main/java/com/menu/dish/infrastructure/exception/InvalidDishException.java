package com.menu.dish.infrastructure.exception;
public class InvalidDishException extends RuntimeException {
    public InvalidDishException(String message) {
        super(message);
    }
}