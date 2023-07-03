package com.amalitech.mentorshiptrackr.seeders;

import com.amalitech.mentorshiptrackr.exceptions.AccountAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Admin;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.services.RoleService;
import com.amalitech.mentorshiptrackr.services.UserService;
import io.github.cdimascio.dotenv.Dotenv;
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

    Dotenv dotenv = Dotenv.load();

    @Override
    public void run(String... args) throws Exception {

        Role adminRole = roleService.findRoleByNameIgnoreCase("Administrator");

        Admin admin = new Admin(
                dotenv.get("SEEDED_ADMIN_USERNAME"),
                dotenv.get("SEEDED_ADMIN_FIRST_NAME"),
                dotenv.get("SEEDED_ADMIN_EMAIL"),
                dotenv.get("SEEDED_ADMIN_PASSWORD"),
                adminRole
        );

        try {
            admin = (Admin) userService.addNewAdminAccount(admin);
            logger.info("'{}' admin account has been seeded successfully.", admin.getEmail());
        } catch (AccountAlreadyExistsException exception) {
            logger.info("'{}' admin account already seeded.", admin.getEmail());
        } catch (Exception exception) {
            logger.error("Something went wrong during seeding admin: %s".formatted(exception.getMessage()));
        }
    }
}
