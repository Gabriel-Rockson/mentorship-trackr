package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.ResponseHandler;
import com.amalitech.mentorshiptrackr.dto.request.AuthenticateUserRequest;
import com.amalitech.mentorshiptrackr.services.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationServiceImpl authenticationService;

    @PostMapping("/v1/authentication/token")
    public ResponseEntity<Object> authenticateUser(
            @RequestBody @NotNull @Valid AuthenticateUserRequest authenticateUserRequest
    ) {
        return ResponseHandler.successResponse(HttpStatus.OK,
                authenticationService.authenticateUser(authenticateUserRequest));
    }
}
