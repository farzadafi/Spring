package com.example.spring_unittest.service.user;

import com.example.spring_unittest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImpelTest {

    @Mock
    private UserRepository userRepository;
    private UserServiceImpel userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpel(userRepository);
    }

    @Test
    void canGetAllUser() {
        //when
        userService.findAll();
        //then
        verify(userRepository).findAll();
    }

    @Test
    @Disabled
    void register() {
    }

    @Test
    @Disabled
    void findById() {
    }

    @Test
    @Disabled
    void findByUsername() {
    }
}