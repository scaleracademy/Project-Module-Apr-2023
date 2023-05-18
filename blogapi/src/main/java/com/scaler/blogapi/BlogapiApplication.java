package com.scaler.blogapi;

import com.scaler.blogapi.security.JWTTokenService;
import com.scaler.blogapi.security.TokenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BlogapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogapiApplication.class, args);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public PasswordEncoder passwordEncoder() {
        /**
         * This is how we can migrate from Bcrypt to Argon2
         */
        var bcryptEncoder = new BCryptPasswordEncoder();
        var argon2Encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return argon2Encoder.encode(rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                var passMatch = argon2Encoder.matches(rawPassword, encodedPassword);
                if (!passMatch) {
                    passMatch = bcryptEncoder.matches(rawPassword, encodedPassword);
                }
                return passMatch;
            }
        };
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public TokenService tokenService() {
        return new JWTTokenService();
    }

}
