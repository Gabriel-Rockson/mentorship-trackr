package com.amalitech.mentorshiptrackr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class AdvisorDTO {
    private UUID id;
    private String username;
    private String email;
    private Map<String, Map<String, String>> location;
}
