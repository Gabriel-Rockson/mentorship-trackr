package com.amalitech.mentorshiptrackr.seeders;

import com.amalitech.mentorshiptrackr.dto.request.RoleRequest;
import com.amalitech.mentorshiptrackr.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Order(2)
@RequiredArgsConstructor
public class RoleSeeder implements CommandLineRunner {
    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        Set<RoleRequest> roles = new HashSet<>();

        roles.add(RoleRequest.builder()
                .name("Administrator")
                .description("Perform all actions")
                .build()
        );

        Set<String> mentorshipManagerPermissions = new HashSet<>();

        mentorshipManagerPermissions.add("manage mentorship");
        mentorshipManagerPermissions.add("view mentorship");

        roles.add(RoleRequest.builder()
                .name("Mentorship manager")
                .description("Perform mentorship associated CRUD actions")
                .permissions(mentorshipManagerPermissions)
                .build()
        );

        roleService.seedRoles(roles);
    }
}
