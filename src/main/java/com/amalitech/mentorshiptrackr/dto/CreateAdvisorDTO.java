package com.amalitech.mentorshiptrackr.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAdvisorDTO {
    @NotBlank(message = "username is required.")
    private String username;
    @Email
    @NotBlank(message = "email is required.")
    private String email;
    @NotBlank(message = "password is required.")
    private String password;
    @NotBlank(message = "countryName is required.")
    private String countryName;
    @NotBlank(message = "cityName is required")
    private String cityName;
}
