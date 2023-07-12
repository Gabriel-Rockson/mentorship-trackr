package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.AuthenticateUserDTO;
import com.amalitech.mentorshiptrackr.dto.ResponseHandler;
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
@RequestMapping("/api/authentication/token")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationServiceImpl authenticationService;

    @PostMapping
    public ResponseEntity<Object> authenticateUser(
            @RequestBody @NotNull @Valid AuthenticateUserDTO authenticateUserDTO
    ) {
        return ResponseHandler.successResponse(HttpStatus.OK,
                authenticationService.authenticateUser(authenticateUserDTO));
    }
}