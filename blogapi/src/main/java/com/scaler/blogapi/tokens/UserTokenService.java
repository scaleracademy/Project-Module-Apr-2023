package com.scaler.blogapi.tokens;

import com.scaler.blogapi.security.TokenService;
import com.scaler.blogapi.users.UsersRepository;
import com.scaler.blogapi.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserTokenService implements TokenService {
    private final UsersRepository usersRepository;
    private final UserTokenRepository userTokenRepository;

    public UserTokenService(
            @Autowired UserTokenRepository userTokenRepository,
            @Autowired UsersRepository usersRepository
    ) {
        this.userTokenRepository = userTokenRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public String createAuthToken(String username) {
        var user = usersRepository.findByUsername(username);
        var token = userTokenRepository.save(UserTokenEntity.builder()
                .user(user)
                .expiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .build()
        );
        return token.getId().toString();
    }

    @Override
    public String getUsernameFromToken(String token) throws IllegalStateException {
        var savedToken = userTokenRepository.findById(UUID.fromString(token));
        if (savedToken.isPresent()) {
            var user = savedToken.get().getUser();
            if (user != null) {
                return user.getUsername();
            }
        }
        // TODO: generate security exception if token is not present etc
        // TODO: check expiry as well
        return null;
    }
}
