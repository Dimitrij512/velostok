package com.dmytro.andrusiv.velostok.services.impl.userDetail;

import com.dmytro.andrusiv.velostok.models.User;
import com.dmytro.andrusiv.velostok.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDtlsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        final User user = userRepository.findOneByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), true, true, true, true,
                Arrays.asList(new SimpleGrantedAuthority(user.getRole().toString())));
    }

}
