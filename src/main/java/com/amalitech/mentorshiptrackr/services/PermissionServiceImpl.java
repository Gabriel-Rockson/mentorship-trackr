package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.repositories.PermissionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
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
    public void seedPermissions(@NotNull @Valid Set<Permission> permissions) {
        for (Permission permission : permissions) {
            try {
                permission = addNewPermission(permission);
                logger.info("'{}' permission has been seeded successfully.", permission.getName());
            } catch (EntityAlreadyExistsException exception) {
                logger.info("'{}' permission already seeded.", permission.getName());
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        }
    }

    @Override
    public Optional<Permission> findByNameIgnoreCase(String permissionName) throws EntityNotFoundException {
        return Optional.ofNullable(permissionRepository.findByNameIgnoreCase(permissionName).orElseThrow(
                () -> new EntityNotFoundException("Permission with name %s not found.".formatted(permissionName))
        ));
    }
}
