package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class LocationData {
    @Column(name = "country", nullable = false)
    private String countryName;
    @Column(name = "city", nullable = false)
    private String cityName;
}
