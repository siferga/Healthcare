package com.siferga.patient.controller;

import com.siferga.patient.model.User;
import com.siferga.patient.service.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userServiceImpl.registration(user);
    }

    @PostMapping("/findByEmail")
    public User getUserByEmail(@RequestBody String email) {
        return userServiceImpl.findUserByEmail(email);
    }

    // Add a new endpoint to get the build version
//    @GetMapping("/buildVersion")
//    public String getBuildVersion() {
//        return buildVersion;
//    }
}
