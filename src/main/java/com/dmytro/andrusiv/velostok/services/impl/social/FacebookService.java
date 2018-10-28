package com.dmytro.andrusiv.velostok.services.impl.social;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class FacebookService {

    @Value("${spring.social.facebook.appId}")
    String facebookAppId;
    @Value("${spring.social.facebook.appSecret}")
    String facebookSecret;

    String accessToken;

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
        accessToken = accessGrant.getAccessToken();
    }

    public User getName() {
        Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
        Facebook facebook = connection.getApi();
        String [] fields = { "id", "email",  "first_name", "last_name","address","birthday","about"};
        User userProfile = facebook.fetchObject("me", User.class, fields);

        return userProfile;
    }
}
