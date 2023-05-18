package com.scaler.blogapi.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersService(
            @Autowired UsersRepository usersRepository,
            @Autowired PasswordEncoder passwordEncoder
    ) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser(String username, String password, String email) {
        var savedUser = usersRepository.save(
                UserEntity.builder()
                        .username(username)
                        .password(passwordEncoder.encode(password))
                        .email(email)
                        .build()
        );
        // TODO 02:
        //  1. create a UserEntity object with the given details
        //  2. save the user using usersRepository.save()
        //    a. validate username min/max lenght
        //    b. hash the password
        //    c. validate email format
        //  3. return the saved user
        return savedUser;
    }

    public UserEntity loginUser(String username, String password) {
        var savedUser = usersRepository.findByUsername(username);

        if (savedUser != null) {
            if (passwordEncoder.matches(password, savedUser.getPassword())) {
                return savedUser;
            }
        }
        throw new IllegalArgumentException("Invalid username or password");
        // TODO: have a proper UserNotFoundException class
        //return null;
    }
}
