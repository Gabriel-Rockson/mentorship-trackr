package com.amalitech.mentorshiptrackr.services;

import com.amalitech.mentorshiptrackr.models.Permission;
import com.amalitech.mentorshiptrackr.repositories.PermissionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PermissionServiceTest {
    // dependency -> PermissionRepository
    // dependant -> PermissionService

    @Mock
    PermissionRepository permissionRepository;

    @InjectMocks
    PermissionServiceImpl permissionService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFindByNameIgnoreCaseSuccess() {
        // given: setup inputs and targets
        Permission permission1 = Permission.builder()
                .id(UUID.randomUUID())
                .name("Read admin list")
                .description("View list of all admins in system.").build();

        given(permissionRepository
                .findByNameIgnoreCase("Read admin list"))
                .willReturn(permission1);

        // when: act on the target
        Permission permission = permissionService.findByNameIgnoreCase("Read admin list");

        // then
        assertThat(permission.getId()).isEqualTo(permission1.getId());
        assertThat(permission.getName()).isEqualTo(permission1.getName());
        assertThat(permission.getDescription()).isEqualTo(permission1.getDescription());
        verify(permissionRepository, times(1))
                .findByNameIgnoreCase("Read admin list");
    }

    @Test
    void testAddNewPermissionSuccess() {
        // given: setup inputs and targets
        Permission permission = Permission.builder()
                .id(UUID.randomUUID())
                .name("Read admin list")
                .description("View list of all admins in system.").build();

        given(permissionRepository.save(permission)).willReturn(permission);

        // when: act on the target
        Permission new_permission = permissionService.addNewPermission(permission);

        // then
        assertThat(new_permission.getId()).isEqualTo(permission.getId());
        assertThat(new_permission.getName()).isEqualTo(permission.getName());
        assertThat(new_permission.getDescription()).isEqualTo(permission.getDescription());
        verify(permissionRepository, times(1)).save(permission);
    }

    @Test
    void permissionExists() {
        // given
        Set<Permission> permissions = new HashSet<>();
        Permission permission1 = Permission.builder()
                .id(UUID.randomUUID())
                .name("Read admin list")
                .description("View list of all admins in system.").build();
        Permission permission2 = Permission.builder()
                .id(UUID.randomUUID())
                .name("Add new admin")
                .description("Add a new administrator to the system").build();

        given(permissionRepository.existsByNameIgnoreCase("read admin list")).willReturn(true);

        // when
        boolean permissionExists = permissionService.permissionExists("read admin list");

        // then
        assertThat(permissionExists).isTrue();
    }
}