package com.example.apps.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Getter
@Setter(AccessLevel.PRIVATE)
@MappedSuperclass
public class AbstractAuditEntity {
    @CreationTimestamp
    private ZonedDateTime createdOn;
    @CreationTimestamp
    private ZonedDateTime updatedOn;
    private ZonedDateTime deletedOn;

    public void softDelete() {
        this.deletedOn = ZonedDateTime.now();
    }
}
