package com.springboot.hroauth.services;

import com.springboot.hroauth.entities.User;
import com.springboot.hroauth.feingclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {

        User user = userFeignClient.findByEmail(email).getBody();

        if (user == null) {
            logger.error("Email not found: {}", email);
            throw new IllegalArgumentException("Email not found");
        }

        return user;
    }

    @Override
    public User loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return findByEmail(username);
    }
}