package com.amalitech.mentorshiptrackr.dto.mapper;

import com.amalitech.mentorshiptrackr.dto.request.AdviseeRequest;
import com.amalitech.mentorshiptrackr.dto.response.AdviseeResponse;
import com.amalitech.mentorshiptrackr.models.Advisee;
import com.amalitech.mentorshiptrackr.models.LocationData;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AdviseeMapper {
    // convert from AdviseeRequest dto to Advisee entity
    public Advisee toAdvisee(AdviseeRequest dto) {
        Advisee entity = new Advisee();

        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setDateOfBirth(dto.getDateOfBirth());

        LocationData locationData = new LocationData();
        locationData.setCountryName(dto.getCountryName());
        locationData.setCityName(dto.getCityName());

        entity.setLocation(locationData);

        return entity;
    }

    // convert from Advisee entity to AdvisorResponse dto
    public AdviseeResponse toAdviseeResponse(Advisee advisee) {
        Map<String, Object> advisorData = new HashMap<>();
        AdviseeResponse dto = new AdviseeResponse();

        dto.setId(advisee.getId());
        dto.setUsername(advisee.getUsername());
        dto.setEmail(advisee.getEmail());
        dto.setDateOfBirth(advisee.getDateOfBirth());
        dto.setLocation(advisee.getLocation());

        if (advisee.getAdvisor() != null) {
            advisorData.put("id", advisee.getAdvisor().getId());
            advisorData.put("email", advisee.getAdvisor().getEmail());

            dto.setAdvisor(advisorData);
        }

        return dto;
    }
}
