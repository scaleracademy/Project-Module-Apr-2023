package com.scaler.blogapi.users.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserRequestDTO {
    @NonNull
    String username;
    @NonNull
    String email;
    @NonNull
    String password;
}
