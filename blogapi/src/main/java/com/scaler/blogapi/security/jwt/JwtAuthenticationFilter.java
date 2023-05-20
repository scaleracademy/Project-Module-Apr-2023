package com.scaler.blogapi.security.jwt;

import com.scaler.blogapi.security.TokenService;
import com.scaler.blogapi.security.UserAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;

public class JwtAuthenticationFilter extends AuthenticationFilter {
    public JwtAuthenticationFilter(TokenService tokenService) {
        super(new JwtAuthenticationManager(tokenService), new JwtAuthenticationConverter());

        /**
         * Every time authentication succeeds, we want to set the Authentication object in the SecurityContext of Spring
         */
        this.setSuccessHandler((request, response, authentication) -> {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });
    }


    /**
     * This class is responsible for converting the request into an Authentication object
     */
    static class JwtAuthenticationConverter implements AuthenticationConverter {

        @Override
        public Authentication convert(HttpServletRequest request) {
            if (request.getHeader("Authorization") != null) {
                String token = request.getHeader("Authorization").replace("Bearer ", "");
                return new UserAuthentication(token);
            }
            return null;
        }
    }

    /**
     * This class is responsible for authenticating the Authentication object
     */
    static class JwtAuthenticationManager implements AuthenticationManager {
        private final TokenService tokenService;

        public JwtAuthenticationManager(TokenService tokenService) {
            this.tokenService = tokenService;
        }

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            if (authentication instanceof UserAuthentication) {
                var userAuthentication = (UserAuthentication) authentication;
                var username = tokenService.getUsernameFromToken(userAuthentication.getCredentials());
                if (username != null) {
                    userAuthentication.setUser(username);
                    return userAuthentication;
                }
            }

            return null;
        }
    }

}
