package com.amalitech.mentorshiptrackr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private UUID id;
    private String userName;
    private String firstName;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;
    private String role;
}
