package com.dmytro.andrusiv.velostok.configuration.social;

import com.dmytro.andrusiv.velostok.models.User;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

public class SocialConfigurer extends SocialConfigurerAdapter {

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
        cfConfig.addConnectionFactory(new FacebookConnectionFactory(
                env.getProperty("1968659599860933"),
                env.getProperty("e4d347bb752d476a96c890f8f17b3c1e")));
    }

    @Override
    public UserIdSource getUserIdSource() {
        //retrieve the UserId from the UserAuthentication in security context
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication.getPrincipal() instanceof User)
                return ((User) authentication.getPrincipal()).getId();
            return authentication.getName();
        };
    }

    /*@Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        SimpleUsersConnectionRepository usersConnectionRepository =
                new SimpleUsersConnectionRepository(userService, connectionFactoryLocator);

        // if no local user record exists yet for a facebook's user id
        // automatically create a User and add it to the database
        usersConnectionRepository.setConnectionSignUp(autoSignUpHandler);

        return usersConnectionRepository;
    }*/
}
