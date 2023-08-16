package com.example.cicddemo.user;

import com.example.cicddemo.error.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserRequestDto userRequestDto) throws DuplicateException {
       Optional<User> userDb = userRepository.findUserByEmailIgnoreCase(userRequestDto.email());
if(userDb.isPresent()){
    throw new DuplicateException("A user with the same email exists");
}
        User user = User.builder()
                .email(userRequestDto.email())
                .firstName(userRequestDto.firstName())
                .lastName(userRequestDto.lastName())
                .build();

        return userRepository.save(user);

    }

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User with id %d not found", id)));
    }

    @Override
    public User findUserByEmail(String email) throws UserNotFoundException {
        return userRepository.findUserByEmailIgnoreCase(email).orElseThrow(() -> new UserNotFoundException(String.format("User with email %s not found", email)));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
