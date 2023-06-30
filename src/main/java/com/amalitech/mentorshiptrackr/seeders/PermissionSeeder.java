package com.amalitech.mentorshiptrackr.seeders;

import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.services.PermissionService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(1)
public class PermissionSeeder implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(PermissionSeeder.class);

    @Autowired
    private PermissionService permissionService;

    @Override
    public void run(String... args) throws Exception {
        List<Permission> permissions = new ArrayList<>();
        permissions.add(
                Permission.builder()
                        .name("Manage mentorship")
                        .description("create, view, update and delete on mentorship(advisors and advisees)")
                        .build()
        );
        permissions.add(
                Permission.builder()
                        .name("View mentorship")
                        .description("view mentorship only")
                        .build()
        );

        for (Permission permission : permissions) {
            permission = permissionService.createPermissionIfNotExists(permission);

            if (permission != null)
                logger.info("'{}' permission has been seeded successfully.", permission.getName());
        }
    }
}
