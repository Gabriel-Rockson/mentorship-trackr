package com.amalitech.mentorshiptrackr.dto;

import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleMapper {
    private final PermissionService permissionService;

    public RoleDTO toDTO(Role entity) {
        RoleDTO dto = new RoleDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPermissions(entity.getPermissions().stream().map(Permission::getName).collect(Collectors.toSet()));

        return dto;
    }

    public Role toEntity(CreateRoleDTO dto) {
        Role entity = new Role();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        Set<Permission> permissions = new HashSet<>();
        dto.getPermissions().forEach(permissionName -> {
            Optional<Permission> permission = permissionService.findByNameIgnoreCase(permissionName);
            permission.ifPresent(permissions::add);
        });

        entity.setPermissions(permissions);

        return entity;
    }
}
