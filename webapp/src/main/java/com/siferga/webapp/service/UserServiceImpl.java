package com.siferga.webapp.service;

import com.siferga.webapp.model.User;
import com.siferga.webapp.service.client.PatientFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final PasswordEncoder passwordEncoder;
    private final PatientFeignClient patientFeignClient;

    public UserServiceImpl(PasswordEncoder passwordEncoder, PatientFeignClient patientFeignClient, PasswordEncoder passwordEncoder1, PatientFeignClient patientFeignClient1) {
        this.passwordEncoder = passwordEncoder;
        this.patientFeignClient = patientFeignClient;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User register(User user) {
        //user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  patientFeignClient.createUser(user);

    }

    @Override
    public User findByUserName(String username) {
        return patientFeignClient.findUserByUsername(username);
    }

}
