package com.example.spring_unittest.service.user;

import com.example.spring_unittest.exception.UsernameDuplicateException;
import com.example.spring_unittest.model.User;
import com.example.spring_unittest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
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
    void canRegisterUser() {
        //given
        User user = User.builder().username("farzadafi").password("abc").build();

        //when
        userService.register(user);

        //then
        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User userAfterSave = userArgumentCaptor.getValue();
        assertThat(userAfterSave).isEqualTo(user);
    }

    @Test
    void canNotRegisterUser() {
        //given
        User user = User.builder().username("farzadafi").password("abc").build();
        given(userRepository.findByUsername(anyString())).willReturn(Optional.of(user));

        //when
        //then
        assertThatThrownBy( () -> userService.register(user))
                .isInstanceOf(UsernameDuplicateException.class)
                .hasMessageContaining(String.format("%s username is exist", user.getUsername()));
        verify(userRepository, never()).save(any());
    }

    @Test
    void findById() {
        userService.findById(1);

        verify(userRepository).findById(1);
    }

    @Test
    void findByUsername() {
        userService.findByUsername("farzad");

        userRepository.findByUsername("farzad");
    }
}