package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Permission;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface PermissionService {
    Optional<Permission> findByNameIgnoreCase(String roleName) throws EntityNotFoundException;

    @Transactional
    Permission addNewPermission(Permission permission) throws EntityAlreadyExistsException;

    boolean permissionExists(String permissionName);
}
