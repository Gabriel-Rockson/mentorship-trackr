package com.amalitech.mentorshiptrackr.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@Embeddable
public class AuditData {
    @CreationTimestamp(source = SourceType.DB)
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}

// TODO: add createdBy and lastModifiedBy fields once you set up Spring security