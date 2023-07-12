package com.amalitech.mentorshiptrackr.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionRequest {
    @NotBlank(message = "name is required.")
    private String name;
    @NotBlank(message = "description is required.")
    private String description;
}