package com.amalitech.mentorshiptrackr.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateUserDTO {
    @NotBlank(message = "This field is required.")
    private String username;

    @NotBlank(message = "This field is required.")
    private String password;
}
