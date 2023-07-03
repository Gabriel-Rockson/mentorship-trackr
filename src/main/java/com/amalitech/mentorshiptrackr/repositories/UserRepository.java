package com.amalitech.mentorshiptrackr.repositories;

import com.amalitech.mentorshiptrackr.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserByEmail(String userEmail);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
