package com.simpleworkoutservice.simpleworkoutservice.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AuditableEntity {

    @Column(name = "created_at")
    private Date createdAt;

    // Default constructor (required for JPA)
    public AuditableEntity() {
        this.createdAt = new Date();
    }

    // Getter and Setter for createdAt

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
