package com.dmytro.andrusiv.velostok.services.impl.social;

import com.dmytro.andrusiv.velostok.enums.ApplRole;
import com.dmytro.andrusiv.velostok.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class FacebookService {

    @Value("${spring.social.facebook.appId}")
    String facebookAppId;
    @Value("${spring.social.facebook.appSecret}")
    String facebookSecret;

    @Autowired
    UserService userService;

    FacebookConnectionFactory connectionFactory;

    AccessGrant accessGrant;

    public String createFacebookAuthorizationURL(){
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("http://localhost:8082/facebook");
        params.setScope("public_profile,email,user_birthday");

        return oauthOperations.buildAuthorizeUrl(params);
    }

    public void createFacebookAccessToken(String code) {
        connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, "http://localhost:8082/facebook", null);
    }

    public  com.dmytro.andrusiv.velostok.models.User getSocialUser() {

        return prepareUser(getFacebookUser());
    }

    private User getFacebookUser() {
        Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
        Facebook facebook = connection.getApi();
        String [] fields = { "id", "email",  "first_name", "last_name","address","birthday","about"};

        return facebook.fetchObject("me", User.class, fields);
    }

    private com.dmytro.andrusiv.velostok.models.User prepareUser(User facebookUser) {

        com.dmytro.andrusiv.velostok.models.User currentUser = userService.findOneByEmail(facebookUser.getEmail());
        if(currentUser == null){
            currentUser = new com.dmytro.andrusiv.velostok.models.User();
            currentUser.setRole(ApplRole.SOCIAL);
            currentUser.setLastName(facebookUser.getLastName());
            currentUser.setFirstName(facebookUser.getFirstName());
            currentUser.setEmail(facebookUser.getEmail());
            currentUser.setPassword(getRandomNumbers());
            currentUser.setImage("*********************");
            currentUser.setId(facebookUser.getId());

            userService.createUser(currentUser);
        }
        return currentUser;
    }

    private String getRandomNumbers() {
        Random rand = new Random();
        return String.format((Locale) null,
                "52%02d-%04d-%04d-%04d",
                rand.nextInt(100),
                rand.nextInt(10000),
                rand.nextInt(10000),
                rand.nextInt(10000));
    }

}
