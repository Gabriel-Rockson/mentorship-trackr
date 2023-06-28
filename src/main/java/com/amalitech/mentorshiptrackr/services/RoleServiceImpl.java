package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.models.Role;
import com.amalitech.mentorshiptrackr.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

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
}
