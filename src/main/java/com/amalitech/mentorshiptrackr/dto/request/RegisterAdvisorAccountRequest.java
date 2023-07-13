package com.amalitech.mentorshiptrackr.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAdvisorAccountRequest extends BaseAdvisorRequest {
    @NotBlank(message = "This field is required.")
    @Size(message = "Password should be 8 characters or more.")
    private String password;
}
