package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Role;
import jakarta.transaction.Transactional;

public interface RoleService {

    Role findRoleByNameIgnoreCase(String roleName);

    @Transactional
    Role addNewRole(Role role) throws EntityAlreadyExistsException;

    boolean roleExists(String roleName);
}
