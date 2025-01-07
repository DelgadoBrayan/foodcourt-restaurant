package com.menu.dish.infrastructure.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.menu.dish.infrastructure.exception.InvalidDishException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidDishException.class)
    public ResponseEntity<String> handleInvalidDishException(InvalidDishException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
}