package com.amalitech.mentorshiptrackr.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
    @NotBlank(message = "name is required.")
    private String name;
    @NotBlank(message = "description is required")
    private String description;
    @NotNull(message = "permissions can't be null")
    private Set<String> permissions;
}