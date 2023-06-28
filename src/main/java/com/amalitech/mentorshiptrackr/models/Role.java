package com.amalitech.mentorshiptrackr.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    private Collection<Permission> permissions;

    @OneToMany(mappedBy = "role")
    private Set<Admin> admins;
}
