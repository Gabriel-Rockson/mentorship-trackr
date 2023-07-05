package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    public Admin(String username, String firstName, String email, String password, Role role) {
        super(username, email, password, role);
        this.firstName = firstName;
    }
}
