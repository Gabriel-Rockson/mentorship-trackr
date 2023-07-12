package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.ResponseHandler;
import com.amalitech.mentorshiptrackr.dto.request.AdvisorRequest;
import com.amalitech.mentorshiptrackr.services.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseStatus(HttpStatus.CREATED)
@RequestMapping("/api/advisors")
@RequiredArgsConstructor
public class AdvisorController {

    private final UserServiceImpl userService;

    @PostMapping("/register-account")
    public ResponseEntity<Object> createNewAdvisorAccount(@RequestBody @NotNull @Valid AdvisorRequest advisorRequest) {
        return ResponseHandler.successResponse(HttpStatus.CREATED, userService.createNewAdvisorAccount(advisorRequest));
    }
}
