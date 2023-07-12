package com.amalitech.mentorshiptrackr.dto.mapper;

import com.amalitech.mentorshiptrackr.dto.response.RoleResponse;
import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleMapper {
    private final PermissionService permissionService;

    public RoleResponse toRoleResponse(Role entity) {
        RoleResponse dto = new RoleResponse();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPermissions(entity.getPermissions().stream().map(Permission::getName).collect(Collectors.toSet()));

        return dto;
    }
}
