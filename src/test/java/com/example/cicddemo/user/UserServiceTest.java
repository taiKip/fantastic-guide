package com.example.cicddemo.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private  UserService userService;
    @MockBean
    private  UserRepository userRepository;
    @BeforeEach
    void setUp() {
User user =
        User
                .builder()
                .email("test@123.com")
                .firstName("victor")
                .lastName("tarus")
                .id(1L)
                .build();
        Mockito.when(userRepository.findUserByEmailIgnoreCase("test@123.com"))
                .thenReturn(Optional.ofNullable(user));
        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.ofNullable(user));
    }

@Test
@DisplayName("Get data based on valid email")
    public void whenValidUserEmail_thenUserShouldFound() throws UserNotFoundException {
        String userEmail = "test@123.com";
        User found =
                userService.findUserByEmail(userEmail);
        assertEquals(userEmail,found.getEmail());

    }
    @Test
    @DisplayName("Get data based on valid user id")
public void whenValidUserId_thenUserShouldFound() throws UserNotFoundException {
      Long  userId = 1L;
      User found =
              userService.findUserById(userId);
      assertEquals(userId,found.getId());
}
}