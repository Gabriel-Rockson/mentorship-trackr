package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.User;
import com.amalitech.mentorshiptrackr.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User addNewAdminAccount(User admin) throws EntityAlreadyExistsException {
        if (usernameExists(admin.getUsername())) {
            throw new EntityAlreadyExistsException("An account with username: %s already exists".formatted(admin.getUsername()));
        }
        if (emailExists(admin.getEmail())) {
            throw new EntityAlreadyExistsException("An account with email: %s already exists".formatted(admin.getUsername()));
        }

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        userRepository.save(admin);

        return admin;
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
