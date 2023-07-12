package com.amalitech.mentorshiptrackr.dto.mapper;

import com.amalitech.mentorshiptrackr.dto.request.AdminRequest;
import com.amalitech.mentorshiptrackr.dto.response.AdminResponse;
import com.amalitech.mentorshiptrackr.models.Admin;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminMapper {

    public AdminResponse toAdminResponse(Admin entity) {
        AdminResponse dto = new AdminResponse();

        // fixme: the getAuditData() is returning null, ask Bonti

        dto.setId(entity.getId());
        dto.setUserName(entity.getUsername());
        dto.setFirstName(entity.getFirstName());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole().getName());

        return dto;
    }

    public Admin toAdmin(AdminRequest dto) {
        Admin entity = new Admin();
        ObjectMapper objectMapper = new ObjectMapper();

        entity.setUsername(dto.getUsername());
        entity.setFirstName(dto.getFirstName());
        entity.setEmail(dto.getEmail());

        return entity;
    }
}
