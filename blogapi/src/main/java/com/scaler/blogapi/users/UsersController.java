package com.scaler.blogapi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/signup")
    ResponseEntity<Void> signupUser() {
        // TODO 01:
        //  1. create a UserSignupDTO (containing username, email, password)
        //  2. call usersService.createUser() with those details
        //  3. respond with 202 ACCEPTED if user is created successfully
    }
}
