package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "advisors")
public class Advisor extends User {
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Embedded
    private LocationData location;

    @OneToMany(mappedBy = "advisor")
    private List<Advisee> advisees;
}
