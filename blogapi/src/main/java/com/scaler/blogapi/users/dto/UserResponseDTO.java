package com.scaler.blogapi.users.dto;

import jakarta.annotation.Nullable;
import lombok.*;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    @NonNull
    String username;
    @NonNull
    String email;
    @Nullable
    String bio;

    String token;
}
