package com.amalitech.mentorshiptrackr.dto.mapper;

import com.amalitech.mentorshiptrackr.dto.request.AdvisorRequest;
import com.amalitech.mentorshiptrackr.dto.response.AdvisorResponse;
import com.amalitech.mentorshiptrackr.models.Advisor;
import com.amalitech.mentorshiptrackr.models.LocationData;
import org.springframework.stereotype.Component;

@Component
public class AdvisorMapper {

    // convert from AdvisorRequest dto to Advisor entity
    public Advisor toAdvisorEntity(AdvisorRequest dto) {

        Advisor newAdvisor = new Advisor();

        newAdvisor.setUsername(dto.getUsername());
        newAdvisor.setEmail(dto.getEmail());
        newAdvisor.setPassword(dto.getPassword());
        newAdvisor.setDateOfBirth(dto.getDateOfBirth());

        LocationData locationData = new LocationData();
        locationData.setCountryName(dto.getCountryName());
        locationData.setCityName(dto.getCityName());

        newAdvisor.setLocation(locationData);

        return newAdvisor;
    }

    // convert from Advisor entity to AdvisorResponse dto
    public AdvisorResponse toAdvisorResponse(Advisor advisor) {


        return AdvisorResponse.builder()
                .id(advisor.getId())
                .username(advisor.getUsername())
                .email(advisor.getEmail())
                .dateOfBirth(advisor.getDateOfBirth())
                // fixme: get the audit data on the advisor object
//                .createdAt(LocalDateTime.from(advisor.getAuditData().getCreatedAt()))
//                .createdAt(LocalDateTime.from(advisor.getAuditData().getUpdatedAt()))
                .location(advisor.getLocation())
                .build();
    }
}
