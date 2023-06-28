package com.amalitech.mentorshiptrackr.repositories;

import com.amalitech.mentorshiptrackr.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByNameIgnoreCase(String roleName);
}
