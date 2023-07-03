package com.amalitech.mentorshiptrackr.exceptions;


public class AccountAlreadyExistsException extends Exception {
    public AccountAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
