package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "advisees")
public class Advisee extends User {
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Embedded
    private LocationData location;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;
}
