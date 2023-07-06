package com.amalitech.mentorshiptrackr.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdminDTO {
    @NotBlank(message = "username is required.")
    @Size(min = 3, message = "username should have at least 3 characters.")
    private String username;

    @NotBlank(message = "firstName is required.")
    private String firstName;

    @NotBlank
    @Email(message = "email is required.")
    private String email;

    @NotBlank
    private String role;
}
