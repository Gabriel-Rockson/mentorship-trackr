package com.amalitech.mentorshiptrackr.dto.mapper;

import com.amalitech.mentorshiptrackr.dto.request.AdvisorRequest;
import com.amalitech.mentorshiptrackr.dto.request.BaseAdvisorRequest;
import com.amalitech.mentorshiptrackr.dto.request.RegisterAdvisorAccountRequest;
import com.amalitech.mentorshiptrackr.dto.response.AdvisorResponse;
import com.amalitech.mentorshiptrackr.models.Advisor;
import com.amalitech.mentorshiptrackr.models.LocationData;
import org.springframework.stereotype.Component;

@Component
public class AdvisorMapper {

    private void commonMapping(BaseAdvisorRequest dto, Advisor newAdvisor) {
        newAdvisor.setUsername(dto.getUsername());
        newAdvisor.setEmail(dto.getEmail());
        newAdvisor.setDateOfBirth(dto.getDateOfBirth());

        LocationData locationData = new LocationData();
        locationData.setCountryName(dto.getCountryName());
        locationData.setCityName(dto.getCityName());

        newAdvisor.setLocation(locationData);
    }

    // convert from AdvisorRequest dto to Advisor entity
    public Advisor toAdvisorEntity(RegisterAdvisorAccountRequest dto) {
        Advisor newAdvisor = new Advisor();

        commonMapping(dto, newAdvisor);
        newAdvisor.setPassword(dto.getPassword());

        return newAdvisor;
    }

    public Advisor toAdvisorEntity(AdvisorRequest dto) {
        Advisor newAdvisor = new Advisor();

        commonMapping(dto, newAdvisor);

        return newAdvisor;
    }


    // convert from Advisor entity to AdvisorResponse dto
    public AdvisorResponse toAdvisorResponse(Advisor advisor) {

        AdvisorResponse dto = new AdvisorResponse();
        dto.setId(advisor.getId());
        dto.setUsername(advisor.getUsername());
        dto.setEmail(advisor.getEmail());
        dto.setDateOfBirth(advisor.getDateOfBirth());
        dto.setLocation(advisor.getLocation());

        return dto;
    }
}
