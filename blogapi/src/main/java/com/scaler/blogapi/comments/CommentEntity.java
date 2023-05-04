package com.scaler.blogapi.comments;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity(name = "comments")
public class CommentEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    UUID id;
}
