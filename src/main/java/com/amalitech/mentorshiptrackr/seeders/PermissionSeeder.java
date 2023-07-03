package com.amalitech.mentorshiptrackr.seeders;

import com.amalitech.mentorshiptrackr.exceptions.PermissionAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Order(1)
@RequiredArgsConstructor
public class PermissionSeeder implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(PermissionSeeder.class);

    private final PermissionService permissionService;

    @Override
    public void run(String... args) throws Exception {

        Set<Permission> permissions = new HashSet<>();
        permissions.add(Permission.builder().name("Manage mentorship").description("create, view, update and delete on mentorship(advisors and advisees)").build());
        permissions.add(Permission.builder().name("View mentorship").description("view mentorship only").build());


        for (Permission permission : permissions) {
            try {
                permission = permissionService.addNewPermission(permission);
                logger.info("'{}' permission has been seeded successfully.", permission.getName());
            } catch (PermissionAlreadyExistsException exception) {
                logger.info("'{}' permission already seeded.", permission.getName());
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        }
    }
}
