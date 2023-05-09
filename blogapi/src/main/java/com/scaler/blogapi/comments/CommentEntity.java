package com.scaler.blogapi.comments;

import com.scaler.blogapi.articles.ArticleEntity;
import com.scaler.blogapi.common.BaseEntity;
import com.scaler.blogapi.users.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity(name = "comments")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class CommentEntity extends BaseEntity {

    @Column(length = 100)
    String title;

    @Column(nullable = false ,length = 1000)
    String body;

    @ManyToOne
    UserEntity author;

    @ManyToOne
    ArticleEntity article;
}
