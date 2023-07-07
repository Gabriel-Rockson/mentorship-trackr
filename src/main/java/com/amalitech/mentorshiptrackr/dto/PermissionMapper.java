package com.amalitech.mentorshiptrackr.dto;

import com.amalitech.mentorshiptrackr.models.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {
    public PermissionDTO toDTO(Permission entity) {
        PermissionDTO dto = new PermissionDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        return dto;
    }

    public Permission toEntity(CreatePermissionDTO dto) {
        Permission entity = new Permission();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        return entity;
    }
}
