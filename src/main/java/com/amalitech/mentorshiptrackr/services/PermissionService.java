package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.models.Permission;
import jakarta.transaction.Transactional;

public interface PermissionService {
    @Transactional
    Permission createPermissionIfNotExists(Permission permission);

    Permission findByNameIgnoreCase(String roleName);
}
