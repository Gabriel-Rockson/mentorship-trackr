package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Username is required")
    @Column(name = "username", nullable = false)
    private String username;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Email is required")
    @Column(name = "email", nullable = false)
    private String email;

    private String password;

    @NotBlank(message = "Role is required")
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
