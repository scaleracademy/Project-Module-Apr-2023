package com.scaler.blogapi.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class UsersRepositoryTests {
    @Autowired private UsersRepository usersRepository;


    @Test
    public void createUser() {
        UserEntity userEntity = new UserEntity(
                "johndoe123",
                "john@gmail.com",
                "johnpass123",
                "John is a nice guy!"
        );
        var user = usersRepository.save(userEntity);
        Assertions.assertNotNull(user.getId());
    }

    @Test
    public void findByUsername() {
        UserEntity userEntity1 = new UserEntity(
                "johndoe123",
                "john@gmail.com",
                "johnpass123",
                "John is a nice guy!"
        );
        UserEntity userEntity2 = new UserEntity(
                "johndoe111",
                "john11@gmail.com",
                "johnpass111",
                "John is another nice guy!"
        );
        usersRepository.save(userEntity1);
        usersRepository.save(userEntity2);

        var user1 = usersRepository.findByUsername("johndoe123");
        var user2 = usersRepository.findByUsername("johndoe111");

        Assertions.assertEquals("john@gmail.com", user1.getEmail());
        Assertions.assertEquals("john11@gmail.com", user2.getEmail());
    }
}
