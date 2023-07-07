package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.AdminDTO;
import com.amalitech.mentorshiptrackr.dto.AdminMapper;
import com.amalitech.mentorshiptrackr.dto.CreateAdminDTO;
import com.amalitech.mentorshiptrackr.models.Admin;
import com.amalitech.mentorshiptrackr.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admins")
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final AdminMapper adminMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AdminDTO addNewAdmin(@RequestBody @Valid CreateAdminDTO adminDTO) {
        Admin admin = (Admin) userService.addNewAdminAccount(adminMapper.toEntity(adminDTO));

        return adminMapper.toDTO(admin);
    }
}
