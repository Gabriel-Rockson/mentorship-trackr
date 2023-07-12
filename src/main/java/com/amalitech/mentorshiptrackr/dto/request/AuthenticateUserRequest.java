package com.amalitech.mentorshiptrackr.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateUserRequest {
    @NotBlank(message = "This field is required.")
    private String username;

    @NotBlank(message = "This field is required.")
    private String password;
}
