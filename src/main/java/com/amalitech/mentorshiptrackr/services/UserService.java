package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.AccountAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.User;

public interface UserService {
    User addNewAdminAccount(User admin) throws AccountAlreadyExistsException;

    boolean usernameExists(String username);

    boolean emailExists(String email);
}
