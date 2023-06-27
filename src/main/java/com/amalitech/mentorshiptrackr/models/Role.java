package com.amalitech.mentorshiptrackr.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;
}
