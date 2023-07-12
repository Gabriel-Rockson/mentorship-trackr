package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.dto.AuthenticateUserDTO;
import com.amalitech.mentorshiptrackr.dto.TokenDTO;

public interface AuthenticationService {
    TokenDTO authenticateUser(AuthenticateUserDTO authenticateUserDTO);
}
