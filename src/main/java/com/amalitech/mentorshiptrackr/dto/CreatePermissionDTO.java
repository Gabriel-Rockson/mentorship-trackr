package com.amalitech.mentorshiptrackr.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePermissionDTO {
    @NotBlank(message = "name is required.")
    private String name;
    @NotBlank(message = "description is required.")
    private String description;
}
