package com.amalitech.mentorshiptrackr.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    private ResponseHandler() {
    }

    public static ResponseEntity<Object> successResponse(@NotNull HttpStatus httpStatus, @NotNull Object responseData) {
        return response("success", httpStatus, responseData);
    }

    public static ResponseEntity<Object> errorResponse(@NotNull HttpStatus httpStatus, @NotNull Object responseData) {
        return response("error", httpStatus, responseData);
    }

    private static ResponseEntity<Object> response(String statusMessage, HttpStatus httpStatus, Object responseData) {
        Map<String, Object> responseObject = new HashMap<>();

        responseObject.put("status", statusMessage);
        responseObject.put("data", responseData);

        return new ResponseEntity<>(responseObject, httpStatus);
    }
}
