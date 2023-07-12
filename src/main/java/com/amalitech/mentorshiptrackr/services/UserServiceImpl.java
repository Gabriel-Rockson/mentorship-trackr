package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.dto.UserPrincipal;
import com.amalitech.mentorshiptrackr.dto.mapper.AdminMapper;
import com.amalitech.mentorshiptrackr.dto.mapper.AdvisorMapper;
import com.amalitech.mentorshiptrackr.dto.request.AdminRequest;
import com.amalitech.mentorshiptrackr.dto.request.AdvisorRequest;
import com.amalitech.mentorshiptrackr.dto.response.AdminResponse;
import com.amalitech.mentorshiptrackr.dto.response.AdvisorResponse;
import com.amalitech.mentorshiptrackr.exceptions.EntityAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Admin;
import com.amalitech.mentorshiptrackr.models.Advisor;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.models.User;
import com.amalitech.mentorshiptrackr.repositories.RoleRepository;
import com.amalitech.mentorshiptrackr.repositories.UserRepository;
import com.amalitech.mentorshiptrackr.utils.PasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AdvisorMapper advisorMapper;
    private final AdminMapper adminMapper;

    private void checkAccountExistence(String username, String email) {
        if (usernameExists(username)) {
            throw new EntityAlreadyExistsException("An account with username: %s already exists".formatted(username));
        }
        if (emailExists(email)) {
            throw new EntityAlreadyExistsException("An account with email: %s already exists".formatted(email));
        }
    }

    @Override
    public User addNewAdminAccount(User admin) throws EntityAlreadyExistsException {
        checkAccountExistence(admin.getUsername(), admin.getEmail());

        Role adminRole = roleRepository.findByNameIgnoreCase("Administrator");

        String password = admin.getPassword();
        if (password == null)
            password = PasswordGenerator.generatePassword(8);

        admin.setPassword(passwordEncoder.encode(password));
        admin.setRole(adminRole);
        userRepository.save(admin);

        logger.info("'The password generated for the user with email {} is {}", admin.getEmail(), password);

        return admin;
    }

    public User addNewAdvisorAccount(User advisor) throws EntityAlreadyExistsException {
        checkAccountExistence(advisor.getUsername(), advisor.getEmail());

        advisor.setPassword(passwordEncoder.encode(advisor.getPassword()));
        userRepository.save(advisor);

        return advisor;
    }

    public AdvisorResponse createNewAdvisorAccount(AdvisorRequest advisorRequest) throws EntityAlreadyExistsException {
        checkAccountExistence(advisorRequest.getUsername(), advisorRequest.getEmail());

        advisorRequest.setPassword(passwordEncoder.encode(advisorRequest.getPassword()));

        Advisor newAdvisor = advisorMapper.toAdvisorEntity(advisorRequest);
        userRepository.save(newAdvisor);

        return advisorMapper.toAdvisorResponse(newAdvisor);
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public AdminResponse createNewAdminAccount(AdminRequest adminRequest) throws EntityAlreadyExistsException {
        checkAccountExistence(adminRequest.getUsername(), adminRequest.getEmail());

        // todo: use roleService to get the role, and raise entity not found in there
        Role adminRole = roleRepository.findByNameIgnoreCase("Administrator");

        String password = PasswordGenerator.generatePassword(8);

        Admin admin = adminMapper.toAdmin(adminRequest);
        admin.setPassword(passwordEncoder.encode(password));
        admin.setRole(adminRole);
        userRepository.save(admin);

        logger.info("'The password generated for the user with email {} is {}", adminRequest.getEmail(), password);

        return adminMapper.toAdminResponse(admin);
    }

    // TODO: allow email to be used for login also as `username`
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " is not found."));
    }
}
