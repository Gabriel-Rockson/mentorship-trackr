package com.amalitech.mentorshiptrackr.exceptions;

public class EntityAlreadyExistsException extends Exception {
    public EntityAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
