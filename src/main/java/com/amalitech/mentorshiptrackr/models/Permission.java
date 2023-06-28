package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @Getter @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "description", nullable = false)
    private String description;

    @Getter @Setter
    @ManyToMany(mappedBy = "permissions")
    private Collection<Role> roles;
}
