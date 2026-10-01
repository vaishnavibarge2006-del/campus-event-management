package com.campus.eventmanagement.service;

import java.util.List;

import com.campus.eventmanagement.dto.UserDto;
import com.campus.eventmanagement.model.User;

public interface UserService {

    User insert(UserDto userDto);

    List<User> getAll();

    User search(Long id);

    User login(String email, String password);
}