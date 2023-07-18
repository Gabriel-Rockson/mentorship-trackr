package com.amalitech.mentorshiptrackr.controllers;

import com.amalitech.mentorshiptrackr.dto.ResponseHandler;
import com.amalitech.mentorshiptrackr.dto.request.AdviseeRequest;
import com.amalitech.mentorshiptrackr.services.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdviseeController {
    private final UserServiceImpl userService;

    @PostMapping("/v1/advisees")
    public ResponseEntity<Object> addNewAdviseeAccount(@NotNull @Valid @RequestBody AdviseeRequest adviseeRequest) {
        return ResponseHandler.successResponse(HttpStatus.CREATED, userService.addNewAdviseeAccount(adviseeRequest));
    }
}
