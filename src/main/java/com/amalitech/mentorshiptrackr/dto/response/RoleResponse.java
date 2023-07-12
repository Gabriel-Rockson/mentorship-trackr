package com.amalitech.mentorshiptrackr.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleResponse {
    private UUID id;
    private String name;
    private String description;
    private Set<String> permissions;
}