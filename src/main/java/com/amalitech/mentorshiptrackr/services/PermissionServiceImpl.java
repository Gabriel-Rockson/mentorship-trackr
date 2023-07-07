package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.repositories.PermissionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    @Transactional
    public Permission addNewPermission(Permission permission) throws EntityAlreadyExistsException {
        if (permissionExists(permission.getName())) {
            throw new EntityAlreadyExistsException("A permission with name: %s already exists.".formatted(permission.getName()));
        }

        permission = permissionRepository.save(permission);

        return permission;
    }

    public boolean permissionExists(String permissionName) {
        return permissionRepository.existsByNameIgnoreCase(permissionName);
    }

    @Override
    public Optional<Permission> findByNameIgnoreCase(String permissionName) throws EntityNotFoundException {
        return Optional.ofNullable(permissionRepository.findByNameIgnoreCase(permissionName).orElseThrow(
                () -> new EntityNotFoundException("Permission with name %s not found.".formatted(permissionName))
        ));
    }
}
