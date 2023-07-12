package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.ResponseHandler;
import com.amalitech.mentorshiptrackr.dto.request.PermissionRequest;
import com.amalitech.mentorshiptrackr.services.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/permissions")
@RestController
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<Object> addNewRole(@RequestBody @Valid PermissionRequest permissionRequest) {
        return ResponseHandler.successResponse(HttpStatus.CREATED,
                permissionService.addNewPermission(permissionRequest));
    }

}
