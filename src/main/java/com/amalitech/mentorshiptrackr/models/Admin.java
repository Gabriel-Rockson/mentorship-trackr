package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "admins")
public class Admin {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Username is required")
    @Getter @Setter
    private String username;

    @NotBlank(message = "First name is required")
    @Getter @Setter
    private String firstname;

    @NotBlank(message = "Email is required")
    @Getter @Setter
    private String email;

    @Getter @Setter
    private String password;

    @NotBlank(message = "Role is required")
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
