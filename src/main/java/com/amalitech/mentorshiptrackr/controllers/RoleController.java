package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.ResponseHandler;
import com.amalitech.mentorshiptrackr.dto.mapper.RoleMapper;
import com.amalitech.mentorshiptrackr.dto.request.RoleRequest;
import com.amalitech.mentorshiptrackr.services.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@ResponseStatus(HttpStatus.CREATED)
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @PostMapping("/v1/roles")
    public ResponseEntity<Object> addNewRole(@RequestBody @Valid RoleRequest roleRequest) {
        return ResponseHandler.successResponse(HttpStatus.CREATED, roleService.addNewRole(roleRequest));
    }
}
