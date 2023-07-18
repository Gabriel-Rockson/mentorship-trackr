package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.ResponseHandler;
import com.amalitech.mentorshiptrackr.dto.request.AdvisorRequest;
import com.amalitech.mentorshiptrackr.dto.request.RegisterAdvisorAccountRequest;
import com.amalitech.mentorshiptrackr.services.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseStatus(HttpStatus.CREATED)
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdvisorController {

    private final UserServiceImpl userService;

    @PostMapping("/v1/advisors")
    public ResponseEntity<Object> addNewAdvisorAccount(@RequestBody @NotNull @Valid AdvisorRequest advisorRequest) {
        return ResponseHandler.successResponse(HttpStatus.CREATED, userService.addNewAdvisorAccount(advisorRequest));
    }

    @PostMapping("v1/advisors/register-account")
    public ResponseEntity<Object> registerNewAdvisorAccount(@RequestBody @NotNull @Valid RegisterAdvisorAccountRequest advisorRequest) {
        return ResponseHandler.successResponse(HttpStatus.CREATED,
                userService.registerNewAdvisorAccount(advisorRequest));
    }
}
