package com.amalitech.mentorshiptrackr.dto;

import com.amalitech.mentorshiptrackr.models.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminMapper {

    public AdminDTO toDTO(Admin entity) {
        AdminDTO dto = new AdminDTO();

        dto.setId(entity.getId());
        dto.setUserName(entity.getUsername());
        dto.setFirstName(entity.getFirstName());
        dto.setEmail(entity.getEmail());
        dto.setCreatedAt(entity.getAuditData().getCreatedAt());
        dto.setUpdatedAt(entity.getAuditData().getUpdatedAt());
        dto.setRole(entity.getRole().getName());

        return dto;
    }

    public Admin toEntity(CreateAdminDTO dto) {
        Admin entity = new Admin();

        entity.setUsername(dto.getUsername());
        entity.setFirstName(dto.getFirstName());
        entity.setEmail(dto.getEmail());

        return entity;
    }
}
