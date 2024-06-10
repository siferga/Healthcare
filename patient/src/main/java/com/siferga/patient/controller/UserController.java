package com.siferga.patient.controller;

import com.siferga.patient.model.User;
import com.siferga.patient.repository.UserRepository;
import com.siferga.patient.service.UserServiceImpl;
import com.siferga.webapp.service.form.SignUpForm;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final UserRepository userRepository;
    private final UserServiceImpl userServiceImpl;

    public UserController(UserRepository userRepository, UserServiceImpl userServiceImpl) {
        this.userRepository = userRepository;
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userServiceImpl.registration(user);
    }

    @PostMapping("/findByUsername")
    public User getUserByUsername(@RequestParam String username) {
        return userRepository.findUserByUsername(username);
    }

    // Add a new endpoint to get the build version
//    @GetMapping("/buildVersion")
//    public String getBuildVersion() {
//        return buildVersion;
//    }
}
