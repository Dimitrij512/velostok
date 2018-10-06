package com.dmytro.andrusiv.velostok.services.impl;

import com.dmytro.andrusiv.velostok.models.User;
import com.dmytro.andrusiv.velostok.repositories.UserRepository;
import com.dmytro.andrusiv.velostok.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> listAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);

    }

    @Override
    public User createUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

}
