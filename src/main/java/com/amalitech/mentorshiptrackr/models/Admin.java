package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Username is required")
    @Getter @Setter
    @Column(name = "username", nullable = false)
    private String username;

    @NotBlank(message = "First name is required")
    @Getter @Setter
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Email is required")
    @Getter @Setter
    @Column(name = "email", nullable = false)
    private String email;

    @Getter @Setter
    private String password;

    @NotBlank(message = "Role is required")
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
