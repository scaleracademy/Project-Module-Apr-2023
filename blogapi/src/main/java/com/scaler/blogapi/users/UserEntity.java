package com.scaler.blogapi.users;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity(name = "users")
public class UserEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    UUID id;

}
