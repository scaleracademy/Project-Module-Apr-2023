package com.scaler.blogapi.users;

import com.scaler.blogapi.security.TokenService;
import com.scaler.blogapi.users.dto.CreateUserRequestDTO;
import com.scaler.blogapi.users.dto.LoginUserRequestDTO;
import com.scaler.blogapi.users.dto.UserResponseDTO;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    private final ModelMapper modelMapper;
    private final TokenService tokenService;

    public UsersController(
            @Autowired UsersService usersService,
            @Autowired ModelMapper modelMapper,
            @Autowired TokenService tokenService
    ) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
        this.tokenService = tokenService;
    }

    @PostMapping("/signup")
    ResponseEntity<UserResponseDTO> signupUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {

        var savedUser = usersService.createUser(
                createUserRequestDTO.getUsername(),
                createUserRequestDTO.getPassword(),
                createUserRequestDTO.getEmail()
        );
        var userResponse = modelMapper.map(savedUser, UserResponseDTO.class);
        userResponse.setToken(tokenService.createAuthToken(savedUser.getUsername()));
        return ResponseEntity.accepted().body(userResponse);
    }

    @PostMapping("/login")
    ResponseEntity<UserResponseDTO> loginUser(@RequestBody LoginUserRequestDTO loginUserRequestDTO) {
        var savedUser = usersService.loginUser(
                loginUserRequestDTO.getUsername(),
                loginUserRequestDTO.getPassword()
        );
        var userResponse = modelMapper.map(savedUser, UserResponseDTO.class);
        userResponse.setToken(tokenService.createAuthToken(savedUser.getUsername()));
        return ResponseEntity.accepted().body(userResponse);
    }

    @GetMapping("/me")
    ResponseEntity<UserResponseDTO> getCurrentUser() {
        // TODO 03:
        //  1. get the username from the token
        //  2. call usersService.getUserByUsername() with that username
        //  3. respond with 200 OK and the user details
        return null;
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponseDTO> getUserById() {
        // TODO 05:
        //  1. call usersService.getUserById() with the id from the path
        //  2. respond with 200 OK and the user details
        return null;
    }

    @PatchMapping("/{id}")
    ResponseEntity<UserResponseDTO> updateUser() {
        // TODO 04:
        //  1. create a UserUpdateDTO (containing email, password, bio)
        //  2. call usersService.updateUser() with those details
        //  3. check that client sends a token which validates this user
        //  4. respond with 202 ACCEPTED if user is updated successfully
        return null;
    }

}
