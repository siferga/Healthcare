package com.siferga.webapp.services.form;

import com.siferga.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class CustomUserDetailsService {
    @Service
    private class CustomUserDetailsService  implements UserDetailsService {
        @Autowired
        private UserServiceImpl userService;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
            User user = userService.findByUserName(username);
            if (user == null) {
                return null;
            }
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getFirstname())
                    .password(user.getPassword())
                    //.roles(user.getRole().name())
                    .build();
        }
    }
}
