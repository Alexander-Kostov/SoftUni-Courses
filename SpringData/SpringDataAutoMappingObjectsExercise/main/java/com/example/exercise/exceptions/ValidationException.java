package com.example.exercise.exceptions;

public class ValidationException extends RuntimeException{

    public ValidationException(String reason) {
        super(reason);
    }
}
