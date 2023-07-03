package com.amalitech.mentorshiptrackr.services;

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
    public Permission createPermissionIfNotExists(Permission permission) {
        Permission permissionInDb  = permissionRepository.findByNameIgnoreCase(permission.getName());

        if (permissionInDb == null) {
            permissionInDb = permission;
            permissionRepository.save(permission);
        }

        return permissionInDb;
    }

    @Override
    public Permission findByNameIgnoreCase(String roleName) {
        return permissionRepository.findByNameIgnoreCase(roleName);
    }
}
