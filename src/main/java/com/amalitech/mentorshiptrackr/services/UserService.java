package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.models.User;

public interface UserService {
    User createUserIfNotExists(User user);
}
