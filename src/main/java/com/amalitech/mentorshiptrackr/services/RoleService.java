package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.RoleAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Role;
import jakarta.transaction.Transactional;

public interface RoleService {

    Role findRoleByNameIgnoreCase(String roleName);

    @Transactional
    Role addNewRole(Role role) throws RoleAlreadyExistsException;

    boolean roleExists(String roleName);
}
