package com.amalitech.mentorshiptrackr.seeders;

import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.services.PermissionService;
import com.amalitech.mentorshiptrackr.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@Order(2)
@RequiredArgsConstructor
public class RoleSeeder implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(RoleSeeder.class);
    private final PermissionService permissionService;
    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        Set<Role> roles = new HashSet<>();

        roles.add(Role.builder()
                .name("Administrator")
                .description("Perform all actions")
                .build()
        );

        Set<Permission> mentorshipManagerPermissions = new HashSet<>();


        Optional<Permission> manageMentorshipPermission = permissionService.findByNameIgnoreCase("manage mentorship");
        Optional<Permission> viewMentorshipPermission = permissionService.findByNameIgnoreCase("view mentorship");

        manageMentorshipPermission.ifPresent(mentorshipManagerPermissions::add);
        viewMentorshipPermission.ifPresent(mentorshipManagerPermissions::add);

        roles.add(Role.builder()
                .name("Mentorship manager")
                .description("Perform mentorship associated CRUD actions")
                .permissions(mentorshipManagerPermissions)
                .build()
        );

        for (Role role : roles) {
            try {
                role = roleService.addNewRole(role);
                logger.info("'{}' role has been seeded successfully.", role.getName());
            } catch (EntityAlreadyExistsException exception) {
                logger.info("'{}' role already seeded.", role.getName());
            } catch (Exception exception) {
                logger.error("Something went wrong during seeding role: {}", exception.getMessage());
            }

        }
    }
}
