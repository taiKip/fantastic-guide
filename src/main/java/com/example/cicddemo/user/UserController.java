package com.example.cicddemo.user;

import com.example.cicddemo.error.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDto userRequestDto) throws DuplicateException {
        return ResponseEntity.ok(userService.createUser(userRequestDto));
    }
    @GetMapping
    public  ResponseEntity<List<User>> findAllUsers(){
       return ResponseEntity.ok(userService.findAllUsers());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<User> findUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.findUserById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<User> findUserByEmail(@RequestParam(value = "email")String email) throws UserNotFoundException {
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

}
