package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.models.User;
import com.amalitech.mentorshiptrackr.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User createUserIfNotExists(User user) {
        User userInDb = userRepository.findUserByEmail(user.getEmail());

        if (userInDb == null) {
            userInDb = user;
            userInDb.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(userInDb);
        }

        return userInDb;
    }
}
