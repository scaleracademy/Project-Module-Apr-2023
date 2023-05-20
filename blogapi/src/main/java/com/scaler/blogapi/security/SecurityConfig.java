package com.scaler.blogapi.security;

import com.scaler.blogapi.security.jwt.JWTTokenService;
import com.scaler.blogapi.security.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private TokenService tokenService;

    public SecurityConfig(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/articles").permitAll()
                .requestMatchers(HttpMethod.POST, "/users/login", "/users/signup").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated();
        http.addFilterBefore(new JwtAuthenticationFilter(tokenService), AnonymousAuthenticationFilter.class);
        return http.build();
    }
}
