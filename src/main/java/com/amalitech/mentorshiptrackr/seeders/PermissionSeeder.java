package com.amalitech.mentorshiptrackr.seeders;

import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Order(1)
@RequiredArgsConstructor
public class PermissionSeeder implements CommandLineRunner {
    private final PermissionService permissionService;

    @Override
    public void run(String... args) throws Exception {

        Set<Permission> permissions = new HashSet<>();
        permissions.add(Permission.builder()
                .name("Manage mentorship")
                .description("create, view, update and delete on mentorship(advisors and advisees)").build()
        );
        permissions.add(Permission.builder()
                .name("View mentorship")
                .description("view mentorship only")
                .build()
        );

        permissionService.seedPermissions(permissions);
    }
}
