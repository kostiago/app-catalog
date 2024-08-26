package com.kostiago.backend.services.exceptions;

public class EntityNotFoundExeception extends RuntimeException {
    
    public EntityNotFoundExeception (String message) {
        super(message);
    }
}
