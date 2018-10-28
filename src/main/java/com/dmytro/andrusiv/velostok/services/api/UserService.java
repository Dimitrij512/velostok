package com.dmytro.andrusiv.velostok.services.api;

import com.dmytro.andrusiv.velostok.models.User;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> listAllUsers();
    User findOneByEmail(String email);
    void deleteById(String id);
    void deleteUser(User user);
    User createUser(User user);
    User updateUser(User user);
    Map.Entry<String, String> getAuthority(Authentication authentication);

}
