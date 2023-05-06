package com.scaler.blogapi.common;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @CreatedDate
    Date createdAt;
}
