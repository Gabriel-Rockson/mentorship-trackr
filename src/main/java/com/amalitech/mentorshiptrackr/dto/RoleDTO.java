package com.amalitech.mentorshiptrackr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class RoleDTO {
    private UUID id;
    private String name;
    private String description;
    private Set<String> permissions;
}
