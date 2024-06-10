package com.siferga.webapp.service;

import com.siferga.webapp.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public User createUser(User user);

    User register(User user);

    User findByUserName(String username);

}
