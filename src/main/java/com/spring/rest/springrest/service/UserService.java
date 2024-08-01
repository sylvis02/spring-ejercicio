package com.spring.rest.springrest.service;

import com.spring.rest.springrest.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    void deleteUser(Long id);

    User updateUser(User user, Long id);

    List<User> getAllUsers();

    User getUserById(Long id);
}
