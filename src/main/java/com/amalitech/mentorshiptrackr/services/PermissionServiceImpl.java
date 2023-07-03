package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.PermissionAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.repositories.PermissionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    @Transactional
    public Permission addNewPermission(Permission permission) throws PermissionAlreadyExistsException {
        if (permissionExists(permission.getName())) {
            throw new PermissionAlreadyExistsException("A permission with name: %s already exists.".formatted(permission.getName()));
        }

        permission = permissionRepository.save(permission);

        return permission;
    }

    public boolean permissionExists(String permissionName) {
        return permissionRepository.existsByNameIgnoreCase(permissionName);
    }

    @Override
    public Permission findByNameIgnoreCase(String roleName) {
        return permissionRepository.findByNameIgnoreCase(roleName);
    }
}
