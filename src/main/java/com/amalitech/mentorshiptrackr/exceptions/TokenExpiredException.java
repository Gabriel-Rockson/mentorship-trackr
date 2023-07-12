package com.amalitech.mentorshiptrackr.exceptions;

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException(String errorMessage) {
        super(errorMessage);
    }
}
