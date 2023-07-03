package com.amalitech.mentorshiptrackr.exceptions;

public class PermissionAlreadyExistsException extends Exception {
    public PermissionAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
