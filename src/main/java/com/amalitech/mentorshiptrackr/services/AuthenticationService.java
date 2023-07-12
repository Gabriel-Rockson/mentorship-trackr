package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.dto.request.AuthenticateUserRequest;
import com.amalitech.mentorshiptrackr.dto.response.TokenResponse;

public interface AuthenticationService {
    TokenResponse authenticateUser(AuthenticateUserRequest authenticateUserRequest);
}
