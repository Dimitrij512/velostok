package com.dmytro.andrusiv.velostok.services.api;

import com.dmytro.andrusiv.velostok.models.User;

import java.util.List;

public interface UserService {

    List<User> listAllUsers();
    User findOneByEmail(String email);
    void deleteById(String id);
    void deleteUser(User user);
    User createUser(User user);
    User updateUser(User user);

}
