package com.amalitech.mentorshiptrackr.seeders;

import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.services.PermissionService;
import com.amalitech.mentorshiptrackr.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Order(2)
public class RoleSeeder implements CommandLineRunner {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    private static final Logger logger = LoggerFactory.getLogger(RoleSeeder.class);

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = new ArrayList<>();

        roles.add(Role.builder()
                .name("Administrator")
                .description("Perform all actions")
                .build()
        );

        Set<Permission> mentorshipManagerPermissions = new HashSet<>();

        Permission manageMentorshipPermission = permissionService.findByNameIgnoreCase("manage mentorship");
        Permission viewMentorshipPermission = permissionService.findByNameIgnoreCase("view mentorship");

        mentorshipManagerPermissions.add(manageMentorshipPermission);
        mentorshipManagerPermissions.add(viewMentorshipPermission);

        roles.add(Role.builder()
                .name("Mentorship manager")
                .description("Perform mentorship associated CRUD actions")
                .permissions(mentorshipManagerPermissions)
                .build()
        );

        for (Role role : roles) {
            role = roleService.createRoleIfNotExists(role);

            if (role != null)
                logger.info("%s role has been seeded successfully".formatted(role.getName()));
        }
    }
}
