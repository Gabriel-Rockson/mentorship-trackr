package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.config.jwt.JWTService;
import com.amalitech.mentorshiptrackr.dto.AuthenticateUserDTO;
import com.amalitech.mentorshiptrackr.dto.TokenDTO;
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
    public TokenDTO authenticateUser(AuthenticateUserDTO authenticateUserDTO) {
        ObjectMapper objectMapper = new ObjectMapper();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticateUserDTO.getUsername(),
                authenticateUserDTO.getPassword()
        ));

        UserDetails user = userService.loadUserByUsername(authenticateUserDTO.getUsername());
        String jwtToken = jwtService.generateJwtToken(user);

        return objectMapper.convertValue(jwtToken, TokenDTO.class);
    }
}
