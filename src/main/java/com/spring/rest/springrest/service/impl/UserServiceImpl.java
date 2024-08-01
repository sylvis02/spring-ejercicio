package com.spring.rest.springrest.service.impl;

import com.spring.rest.springrest.entities.User;
import com.spring.rest.springrest.exception.AppException;
import com.spring.rest.springrest.repository.UserCRUDRepository;
import com.spring.rest.springrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserCRUDRepository userCRUDRepository;

    @Override
    public User createUser(User user) {
        return userCRUDRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userCRUDRepository.findById(id)
                .orElseThrow(() -> new AppException(404, "User not found"));
        userCRUDRepository.delete(user);
    }

    @Override
    public User updateUser(User user, Long id) {
       User userToUpdate = userCRUDRepository.findById(id)
               .orElseThrow(() -> new AppException(404, "User not found"));
        user.setUserId(id);
        userToUpdate = userCRUDRepository.save(user);
        return userToUpdate;
    }

    @Override
    public List<User> getAllUsers() {
       List<User> users = (List<User>) userCRUDRepository.findAll();
       return users;
    }

    @Override
    public User getUserById(Long id) {
        User userToUpdate = userCRUDRepository.findById(id)
                .orElseThrow(() -> new AppException(404, "User not found"));
        return userToUpdate;
    }
}
