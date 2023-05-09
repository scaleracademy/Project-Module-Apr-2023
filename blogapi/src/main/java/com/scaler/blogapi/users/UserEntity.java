package com.scaler.blogapi.users;

import com.scaler.blogapi.articles.ArticleEntity;
import com.scaler.blogapi.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@ToString
@Entity(name = "users")
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class UserEntity extends BaseEntity {

    @NonNull
    @Column(nullable = false, unique = true, length = 30)
    String username;
    @NonNull
    @Column(nullable = false, unique = true, length = 50)
    String email;
    @NonNull
    @Column(nullable = false)
    String password;        // TODO: do not save password in plain text

    @Column
    String bio;

    @ManyToMany(targetEntity = UserEntity.class, mappedBy = "following")
    List<UserEntity> followers;

    @ManyToMany
    List<UserEntity> following;

    @ManyToMany(targetEntity = ArticleEntity.class, mappedBy = "likes")
    List<ArticleEntity> favouriteArticles;
}
