package com.amalitech.mentorshiptrackr.exceptions;

import com.amalitech.mentorshiptrackr.dto.ResponseHandler;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Map<String, String> generateErrorMessage(String errorMessage) {
        Map<String, String> errorData = new HashMap<>();
        errorData.put("message", errorMessage);

        return errorData;
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<Object> handleEntityAlreadyExistsException(HttpServletRequest request,
                                                                     EntityAlreadyExistsException exception) {
        return ResponseHandler.errorResponse(HttpStatus.BAD_REQUEST, generateErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(HttpServletRequest request,
                                                                EntityNotFoundException exception) {
        return ResponseHandler.errorResponse(HttpStatus.BAD_REQUEST, generateErrorMessage(exception.getMessage()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInvalidArgumentException(HttpServletRequest request,
                                                                 MethodArgumentNotValidException exception) {
        Map<String, String> errorData = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> errorData.put(error.getField(), error.getDefaultMessage()));

        return ResponseHandler.errorResponse(HttpStatus.BAD_REQUEST, errorData);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentialsException(HttpServletRequest request,
                                                                BadCredentialsException exception) {
        return ResponseHandler.errorResponse(
                HttpStatus.UNAUTHORIZED, generateErrorMessage("Incorrect username and / " + "or password")
        );
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(HttpServletRequest request,
                                                                AuthenticationException exception) {
        return ResponseHandler.errorResponse(HttpStatus.UNAUTHORIZED, generateErrorMessage("User not authorized to " +
                "perform action."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllOtherExceptions(HttpServletRequest request, Exception exception) {
        return ResponseHandler.errorResponse(HttpStatus.UNAUTHORIZED, generateErrorMessage(exception.getMessage()));
    }
}
