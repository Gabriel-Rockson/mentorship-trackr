package com.amalitech.mentorshiptrackr.seeders;

import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Admin;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.services.RoleService;
import com.amalitech.mentorshiptrackr.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
@Order(3)
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AdminSeeder.class);

    private final RoleService roleService;

    private final UserService userService;

    private final Environment environment;

    @Override
    public void run(String... args) throws Exception {

        Role adminRole = roleService.findRoleByNameIgnoreCase("Administrator");

        Admin admin = new Admin(
                environment.getProperty("SEEDED_ADMIN_USERNAME"),
                environment.getProperty("SEEDED_ADMIN_FIRST_NAME"),
                environment.getProperty("SEEDED_ADMIN_EMAIL"),
                environment.getProperty("SEEDED_ADMIN_PASSWORD"),
                adminRole
        );

        try {
            admin = (Admin) userService.addNewAdminAccount(admin);
            logger.info("'{}' admin account has been seeded successfully.", admin.getEmail());
        } catch (EntityAlreadyExistsException exception) {
            logger.info("'{}' admin account already seeded.", admin.getEmail());
        } catch (Exception exception) {
            logger.error("Something went wrong during seeding admin: %s".formatted(exception.getMessage()));
        }
    }
}
