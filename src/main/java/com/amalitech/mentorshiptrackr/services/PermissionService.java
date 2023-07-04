package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Permission;
import jakarta.transaction.Transactional;

public interface PermissionService {
    Permission findByNameIgnoreCase(String roleName);

    @Transactional
    Permission addNewPermission(Permission permission) throws EntityAlreadyExistsException;

    boolean permissionExists(String permissionName);
}
