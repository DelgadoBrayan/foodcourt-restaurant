package com.menu.dish.infrastructure.exception;

public class InvalidEmployeeException extends RuntimeException {
    
    public InvalidEmployeeException(String message){
        super(message);
    }
}
