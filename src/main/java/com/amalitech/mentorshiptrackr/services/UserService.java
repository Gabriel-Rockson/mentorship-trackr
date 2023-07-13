package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.dto.request.AdminRequest;
import com.amalitech.mentorshiptrackr.dto.request.AdviseeRequest;
import com.amalitech.mentorshiptrackr.dto.request.AdvisorRequest;
import com.amalitech.mentorshiptrackr.dto.request.RegisterAdvisorAccountRequest;
import com.amalitech.mentorshiptrackr.dto.response.AdminResponse;
import com.amalitech.mentorshiptrackr.dto.response.AdviseeResponse;
import com.amalitech.mentorshiptrackr.dto.response.AdvisorResponse;
import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService {
    User addNewAdminAccount(User admin) throws EntityAlreadyExistsException;

    AdvisorResponse addNewAdvisorAccount(AdvisorRequest advisorRequest) throws EntityAlreadyExistsException;

    AdvisorResponse registerNewAdvisorAccount(RegisterAdvisorAccountRequest request) throws EntityAlreadyExistsException;

    boolean usernameExists(String username);

    boolean emailExists(String email);

    AdminResponse createNewAdminAccount(AdminRequest adminRequest) throws EntityAlreadyExistsException;

    AdviseeResponse addNewAdviseeAccount(AdviseeRequest adviseeRequest) throws EntityAlreadyExistsException;

    Optional<User> findByUsernameOrEmail(String username);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
