package com.amalitech.mentorshiptrackr.exceptions;


import lombok.Getter;

@Getter
public class APIErrorInfo {
    private final String errorMessage;

    public APIErrorInfo(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
