package com.campus.eventmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campus.eventmanagement.dto.UserDto;
import com.campus.eventmanagement.model.User;
import com.campus.eventmanagement.service.UserService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable Long id) {

        User user = userService.search(id);

        if (user != null) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.notFound().build();
    }

    // Add user
    @PostMapping
    public User addUser(@RequestBody UserDto userDto) {
        return userService.insert(userDto);
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto userDto) {

        User user = userService.login(
            userDto.getEmail(),
            userDto.getPassword()
        );

        if (user != null) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}