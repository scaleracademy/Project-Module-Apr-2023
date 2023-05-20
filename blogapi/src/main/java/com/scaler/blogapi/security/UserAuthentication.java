package com.scaler.blogapi.security;

import com.scaler.blogapi.users.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthentication implements Authentication {

    /**
     * Can be either a JWT or a UUID of server-based token
     */
    private final String token;

    private String username;

    public UserAuthentication(String token) {
        this.token = token;
    }

    public void setUser(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO: not implementing this right now
        return null;
    }

    @Override
    public String getCredentials() {
        return token;
    }

    @Override
    public Object getDetails() {
        // TODO: not implementing this right now
        return null;
    }

    @Override
    public String getPrincipal() {
        return this.username;
    }

    @Override
    public boolean isAuthenticated() {
        return username != null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (!isAuthenticated) {
            this.username = null;
        }
    }

    @Override
    public String getName() {
        // TODO: return username
        return null;
    }
}
