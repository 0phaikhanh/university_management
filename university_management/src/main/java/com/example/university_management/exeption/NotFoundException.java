package com.example.university_management.exeption;
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}