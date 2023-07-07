package com.amalitech.mentorshiptrackr.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseStatus(HttpStatus.CREATED)
@RequestMapping("/api/advisors")
@RequiredArgsConstructor
public class AdvisorController {

    @PostMapping("/register")
    public String createMentorAccount() {
        return "Create::account";
    }
}
