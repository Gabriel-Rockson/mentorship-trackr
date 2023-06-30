package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "admins")
public class Admin extends User {
    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Admin(String username, String firstName, String email, String password, Role role) {
        super(username, email, password);
        this.firstName = firstName;
        this.role = role;
    }
}
