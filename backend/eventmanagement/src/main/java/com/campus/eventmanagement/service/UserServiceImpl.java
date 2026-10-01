package com.campus.eventmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.eventmanagement.dto.UserDto;
import com.campus.eventmanagement.model.User;
import com.campus.eventmanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User insert(UserDto userDto) {

        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User search(Long id) {

        User user = userRepository.findById(id).orElse(null);

        return user;
    }
    @Override
    public User login(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {

            User user = userOptional.get();

            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }
}