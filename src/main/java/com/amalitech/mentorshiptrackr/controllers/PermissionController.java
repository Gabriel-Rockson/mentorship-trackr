package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.CreatePermissionDTO;
import com.amalitech.mentorshiptrackr.dto.PermissionDTO;
import com.amalitech.mentorshiptrackr.dto.PermissionMapper;
import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.services.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/permissions")
@RestController
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;
    private final PermissionMapper permissionMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PermissionDTO addNewRole(@RequestBody @Valid CreatePermissionDTO permissionDTO) {
        Permission permission = permissionService
                .addNewPermission(permissionMapper.toEntity(permissionDTO));

        return permissionMapper.toDTO(permission);
    }

}
