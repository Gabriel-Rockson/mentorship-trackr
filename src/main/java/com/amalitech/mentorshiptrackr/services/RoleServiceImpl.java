package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public Role createRoleIfNotExists(Role role) {
        Role roleInDB = roleRepository.findByNameIgnoreCase(role.getName());

        if (roleInDB == null) {
            roleInDB = role;
            roleRepository.save(roleInDB);
        }

        return roleInDB;
    }

    public Role findRoleByNameIgnoreCase(String roleName) {
        return roleRepository.findByNameIgnoreCase(roleName);
    }
}
