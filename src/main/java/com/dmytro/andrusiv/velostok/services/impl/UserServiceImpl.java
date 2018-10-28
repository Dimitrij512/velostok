package com.dmytro.andrusiv.velostok.services.impl;


import com.dmytro.andrusiv.velostok.models.User;
import com.dmytro.andrusiv.velostok.repositories.UserRepository;
import com.dmytro.andrusiv.velostok.services.api.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

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
        return userRepository.insert(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Map.Entry<String, String> getAuthority(Authentication authentication) {
        return new AbstractMap.SimpleEntry<String, String>(ROLE,
                authentication.getAuthorities().stream().findFirst().get().getAuthority());
    }

}
