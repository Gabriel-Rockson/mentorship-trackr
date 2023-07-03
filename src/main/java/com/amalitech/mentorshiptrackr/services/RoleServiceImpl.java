package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.exceptions.RoleAlreadyExistsException;
import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.repositories.RoleRepository;
import com.amalitech.mentorshiptrackr.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Role addNewRole(Role role) throws RoleAlreadyExistsException {
        if (roleExists(role.getName())) {
            throw new RoleAlreadyExistsException("A role with name: %s already exists.".formatted(role.getName()));
        }

        role = roleRepository.save(role);
        return role;
    }

    @Override
    public boolean roleExists(String roleName) {
        return roleRepository.existsByNameIgnoreCase(roleName);
    }


    public Role findRoleByNameIgnoreCase(String roleName) {
        return roleRepository.findByNameIgnoreCase(roleName);
    }
}
