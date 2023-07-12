package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Username is required.")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Email(message = "Invalid email.")
    @NotBlank(message = "Email is required.")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private @Column(name = "password", nullable = false)
    String password;

    @Embedded
    private AuditData auditData;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
