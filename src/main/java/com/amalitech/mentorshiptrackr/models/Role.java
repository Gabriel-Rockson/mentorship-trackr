package com.amalitech.mentorshiptrackr.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "description", nullable = false)
    private String description;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    private Collection<Permission> permissions;

    @Getter @Setter
    @OneToMany(mappedBy = "role")
    private Set<Admin> admins;
}
