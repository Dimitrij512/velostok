package com.dmytro.andrusiv.velostok.controllers;

import com.dmytro.andrusiv.velostok.models.User;
import com.dmytro.andrusiv.velostok.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @GetMapping("/authority")
    public ResponseEntity<Map.Entry<String, String>> getAuthority(Authentication authentication) {
        return new ResponseEntity<Map.Entry<String, String>>(userService.getAuthority(authentication), HttpStatus.OK);
    }

    @PostMapping("/testUser")
    public User getUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}