package com.amalitech.mentorshiptrackr.exceptions;

public class RoleAlreadyExistsException extends Exception {
    public RoleAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
