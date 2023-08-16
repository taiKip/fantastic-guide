package com.example.cicddemo.user;

import com.example.cicddemo.error.DuplicateException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(UserRequestDto userDto) throws DuplicateException;

    User findUserById(Long id) throws UserNotFoundException;

    User findUserByEmail(String email) throws UserNotFoundException;

    List<User> findAllUsers();
}
