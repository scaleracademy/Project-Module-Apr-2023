package com.scaler.blogapi.users;

import com.scaler.blogapi.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true, length = 30)
    String username;
    @Column(nullable = false, unique = true, length = 50)
    String email;
    @Column(nullable = false)
    String password;        // TODO: do not save password in plain text
    @Column
    String bio;

    @ManyToMany(/* TODO: figure this out */ )
    List<UserEntity> followers;
    @ManyToMany(/* TODO: figure this out */ )
    List<UserEntity> following;
}
