package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.config.jwt.JWTService;
import com.amalitech.mentorshiptrackr.dto.request.AuthenticateUserRequest;
import com.amalitech.mentorshiptrackr.dto.response.TokenResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final JWTService jwtService;

    @Override
    public TokenResponse authenticateUser(AuthenticateUserRequest authenticateUserRequest) {
        ObjectMapper objectMapper = new ObjectMapper();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticateUserRequest.getUsername(),
                authenticateUserRequest.getPassword()
        ));

        UserDetails user = userService.loadUserByUsername(authenticateUserRequest.getUsername());
        String jwtToken = jwtService.generateJwtToken(user);

        return objectMapper.convertValue(jwtToken, TokenResponse.class);
    }
}
