package com.amalitech.mentorshiptrackr.dto.request;

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
public class AdminRequest {
    @NotBlank(message = "This field is required.")
    @Size(min = 3, message = "username should have at least 3 characters.")
    private String username;

    @NotBlank(message = "This field is required.")
    private String firstName;

    @NotBlank(message = "This field is required.")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "This field is required")
    private String role;
}



