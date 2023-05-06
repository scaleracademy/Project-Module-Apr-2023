package com.scaler.blogapi.users;

import com.scaler.blogapi.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
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
}
