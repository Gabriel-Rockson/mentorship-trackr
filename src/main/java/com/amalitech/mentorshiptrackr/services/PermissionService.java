package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.dto.request.PermissionRequest;
import com.amalitech.mentorshiptrackr.dto.response.PermissionResponse;
import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Permission;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.Set;

public interface PermissionService {
    Optional<Permission> findByNameIgnoreCase(String roleName) throws EntityNotFoundException;

    @Transactional
    PermissionResponse addNewPermission(PermissionRequest permissionRequest) throws EntityAlreadyExistsException;

    boolean permissionExists(String permissionName);

    void seedPermissions(Set<PermissionRequest> permissions);
}
