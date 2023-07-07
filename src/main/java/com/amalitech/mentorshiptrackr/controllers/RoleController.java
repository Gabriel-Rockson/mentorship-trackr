package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.CreateRoleDTO;
import com.amalitech.mentorshiptrackr.dto.RoleDTO;
import com.amalitech.mentorshiptrackr.dto.RoleMapper;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.services.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/roles")
@RestController
@ResponseStatus(HttpStatus.CREATED)
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @PostMapping
    public RoleDTO addNewRole(@RequestBody @Valid CreateRoleDTO dto) {
        Role role = roleService.addNewRole(roleMapper.toEntity(dto));

        return roleMapper.toDTO(role);
    }
}
