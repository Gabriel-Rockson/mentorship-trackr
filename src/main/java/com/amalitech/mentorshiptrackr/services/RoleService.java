package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.models.Role;
import jakarta.transaction.Transactional;

public interface RoleService {
    @Transactional
    Role createRoleIfNotExists(Role role);

    Role findRoleByNameIgnoreCase(String roleName);
}
