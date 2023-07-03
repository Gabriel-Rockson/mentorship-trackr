package com.amalitech.mentorshiptrackr.seeders;

import com.amalitech.mentorshiptrackr.models.Admin;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.services.RoleService;
import com.amalitech.mentorshiptrackr.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AdminSeeder.class);

    private final RoleService roleService;

    private final UserService userService;


    @Override
    public void run(String... args) throws Exception {

        Role adminRole = roleService.findRoleByNameIgnoreCase("Administrator");

        Admin admin = new Admin(
                "gabriel_rockson",
                "Gabriel",
                "admin.gabriel@mentorshipTracker.com",
                "!a@s423Q",
                adminRole
        );

        admin = (Admin) userService.createUserIfNotExists(admin);

        if (admin != null) {
            logger.info("'{}' admin account has been seeded successfully.", admin.getEmail());
        }
    }
}
