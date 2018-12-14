package com.dmytro.andrusiv.velostok.services.impl;


import com.dmytro.andrusiv.velostok.enums.ApplRole;
import com.dmytro.andrusiv.velostok.models.User;
import com.dmytro.andrusiv.velostok.repositories.UserRepository;
import com.dmytro.andrusiv.velostok.services.api.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    public static final String ROLE = "role";

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



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
        User tempUser = userRepository.findOneByEmail(user.getEmail());
        if (tempUser == null) {
            tempUser = userRepository.insert(prepareUser(user));
        }
        return tempUser;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Map.Entry<String, String> getAuthority(Authentication authentication) {
        return new AbstractMap.SimpleEntry<>(ROLE,
                authentication.getAuthorities().stream().findFirst().get().getAuthority());
    }

    private User prepareUser(User user) {
        User prepareUser = new User();
        prepareUser.setRole(user.getRole());
        prepareUser.setLastName(user.getLastName());
        prepareUser.setFirstName(user.getFirstName());
        prepareUser.setEmail(user.getEmail());
        prepareUser.setPassword(bCryptPasswordEncoder.encode(user.getPhotoUrl()));
        prepareUser.setPhotoUrl(user.getPhotoUrl());
        prepareUser.setName(user.getName());

        return prepareUser;
    }

}
