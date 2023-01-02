package com.example.spring_unittest.repository;

import com.example.spring_unittest.model.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    @Order(1)
    void findByUsername_userExists_true() {
        //given
        User user = User.builder().username("farzadafi").password("abc").build();
        repository.save(user);

        //when
        Optional<User> optionalUser = repository.findByUsername(user.getUsername());

        //then
        assertThat(optionalUser.isPresent()).isTrue();
    }

    @Test
    @Order(2)
    void findByUsername_userDoesNotExists_false() {
        //given
        String username = "naser";

        //when
        Optional<User> optionalUser = repository.findByUsername(username);

        //then
        assertThat(optionalUser.isPresent()).isFalse();
    }
}