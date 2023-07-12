package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.ResponseHandler;
import com.amalitech.mentorshiptrackr.dto.mapper.AdminMapper;
import com.amalitech.mentorshiptrackr.dto.request.AdminRequest;
import com.amalitech.mentorshiptrackr.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admins")
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final AdminMapper adminMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addNewAdmin(@RequestBody @Valid AdminRequest adminRequest) {
        return ResponseHandler.successResponse(HttpStatus.CREATED, userService.createNewAdminAccount(adminRequest));
    }
}
