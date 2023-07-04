package com.amalitech.mentorshiptrackr.exceptions;

public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
