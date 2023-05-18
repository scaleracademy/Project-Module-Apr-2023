package com.scaler.blogapi.common;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

@Getter(AccessLevel.PUBLIC)
@MappedSuperclass
public abstract class BaseEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @CreationTimestamp
    Date createdAt;
}
