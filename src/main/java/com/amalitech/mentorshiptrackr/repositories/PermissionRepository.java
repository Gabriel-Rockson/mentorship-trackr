package com.amalitech.mentorshiptrackr.repositories;

import com.amalitech.mentorshiptrackr.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
    Permission findByNameIgnoreCase(String permissionName);

    boolean existsByNameIgnoreCase(String permissionName);
}
