package com.amalitech.mentorshiptrackr.dto;

import com.amalitech.mentorshiptrackr.models.Advisor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AdvisorMapper {

    private Map<String, Map<String, String>> location;

    public AdvisorDTO toDTO(Advisor advisor) {
        AdvisorDTO dto = new AdvisorDTO();

        dto.setId(advisor.getId());
        dto.setUsername(advisor.getUsername());
        dto.setEmail(advisor.getEmail());

        location.put("location")

        return dto;
    }
}
