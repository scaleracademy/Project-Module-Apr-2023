package com.scaler.blogapi.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UsersService(
            @Autowired UsersRepository usersRepository,
            @Autowired ModelMapper modelMapper
    ) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public UserEntity createUser(String username, String password, String email) {
        // TODO 02:
        //  1. create a UserEntity object with the given details
        //  2. save the user using usersRepository.save()
        //    a. validate username min/max lenght
        //    b. hash the password
        //    c. validate email format
        //  3. return the saved user
        return null;
    }
}
