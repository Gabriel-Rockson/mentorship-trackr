package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.dto.request.RoleRequest;
import com.amalitech.mentorshiptrackr.dto.response.RoleResponse;
import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Role;
import jakarta.transaction.Transactional;

import java.util.Set;

public interface RoleService {

    Role findRoleByNameIgnoreCase(String roleName);

    @Transactional
    RoleResponse addNewRole(RoleRequest roleRequest) throws EntityAlreadyExistsException;

    boolean roleExists(String roleName);

    @Transactional
    void seedRoles(Set<RoleRequest> roleRequests);
}
