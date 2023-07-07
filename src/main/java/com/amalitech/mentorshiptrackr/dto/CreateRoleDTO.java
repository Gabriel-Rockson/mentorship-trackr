package com.amalitech.mentorshiptrackr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateRoleDTO {
    @NotBlank(message = "name is required.")
    private String name;
    @NotBlank(message = "description is required")
    private String description;
    @NotNull(message = "permissions can't be null")
    private Set<String> permissions;
}
