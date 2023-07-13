package com.amalitech.mentorshiptrackr.dto.response;

import com.amalitech.mentorshiptrackr.models.LocationData;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonAdvisorAdviseeResponse {
    private UUID id;
    private String username;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private LocationData location;
}
