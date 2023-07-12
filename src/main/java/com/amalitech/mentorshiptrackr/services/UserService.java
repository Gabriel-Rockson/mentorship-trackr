package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.dto.request.AdminRequest;
import com.amalitech.mentorshiptrackr.dto.response.AdminResponse;
import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.User;

public interface UserService {
    User addNewAdminAccount(User admin) throws EntityAlreadyExistsException;

    boolean usernameExists(String username);

    boolean emailExists(String email);

    AdminResponse createNewAdminAccount(AdminRequest adminRequest) throws EntityAlreadyExistsException;
}
