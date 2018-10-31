package com.dmytro.andrusiv.velostok.controllers;

import com.dmytro.andrusiv.velostok.services.api.UserService;
import com.dmytro.andrusiv.velostok.services.impl.social.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.social.facebook.api.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @Autowired
    FacebookService facebookService;

    @GetMapping("/authority")
    public ResponseEntity<Map.Entry<String, String>> getAuthority(Authentication authentication) {
        return new ResponseEntity<Map.Entry<String, String>>(userService.getAuthority(authentication), HttpStatus.OK);
    }


    @GetMapping("/createFacebookAuthorization")
    public String createFacebookAuthorization() {
        return facebookService.createFacebookAuthorizationURL();
    }

    @GetMapping("/facebook")
    public void createFacebookAccessToken(@RequestParam("code") String code){
        facebookService.createFacebookAccessToken(code);
    }

    @GetMapping("/getSocialUser")
    public com.dmytro.andrusiv.velostok.models.User getNameResponse(){
        return facebookService.getSocialUser();
    }

}