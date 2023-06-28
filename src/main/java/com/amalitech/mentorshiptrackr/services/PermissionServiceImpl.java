package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.repositories.PermissionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

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
