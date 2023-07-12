package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.dto.mapper.RoleMapper;
import com.amalitech.mentorshiptrackr.dto.request.RoleRequest;
import com.amalitech.mentorshiptrackr.dto.response.RoleResponse;
import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.repositories.RoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    private final RoleRepository roleRepository;
    private final PermissionService permissionService;
    private final RoleMapper roleMapper;

    @Override
    @Transactional
    public RoleResponse addNewRole(RoleRequest roleRequest) throws EntityAlreadyExistsException {
        if (roleExists(roleRequest.getName())) {
            throw new EntityAlreadyExistsException("A role with name: %s already exists.".formatted(roleRequest.getName()));
        }
        Set<Permission> permissions = new HashSet<>();
        Set<String> permissionsList = roleRequest.getPermissions();

        if (permissionsList != null) {
            for (String permissionName : permissionsList) {
                Optional<Permission> permission = permissionService.findByNameIgnoreCase(permissionName);
                permission.ifPresent(permissions::add);
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Role role = objectMapper.convertValue(roleRequest, Role.class);
        role.setPermissions(permissions);
        role = roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    @Transactional
    public void seedRoles(Set<RoleRequest> roleRequests) {
        for (RoleRequest roleRequest : roleRequests) {
            try {
                RoleResponse role = addNewRole(roleRequest);
                logger.info("'{}' role has been seeded successfully.", role.getName());
            } catch (EntityAlreadyExistsException exception) {
                logger.info("'{}' role already seeded.", roleRequest.getName());
            } catch (Exception exception) {
                logger.error("Something went wrong during seeding role with name '{}': {}",
                        roleRequest.getName(), exception.getMessage());
            }
        }
    }

    @Override
    public boolean roleExists(String roleName) {
        return roleRepository.existsByNameIgnoreCase(roleName);
    }


    public Role findRoleByNameIgnoreCase(String roleName) {
        return roleRepository.findByNameIgnoreCase(roleName);
    }
}
