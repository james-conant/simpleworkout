package com.simpleworkoutservice.simpleworkoutservice.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class AuditableEntity {

    @Column(name = "created_at")
    private Date createdAt;

}
