package com.siferga.webapp.controller;

import ch.qos.logback.core.model.Model;
import com.siferga.webapp.model.User;
import com.siferga.webapp.service.UserServiceImpl;
import com.siferga.webapp.service.form.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/")
    public ModelAndView home(Model model) {
        return new ModelAndView("index");
    }

    @GetMapping ("/logOut")
    public String logOut(){
        return "signin";
    }

    /*********************************** SIGNUP ******************************************/


    @GetMapping("/login")
    public ModelAndView Login() {
        return new ModelAndView("signin");
    }

    @PostMapping("/signup")
    public ModelAndView processRequest(@ModelAttribute User user) {
        userServiceImpl.register(user);
        return new ModelAndView("signin");

    }

    //    @PostMapping("/signup")
//    public String registerUser(@ModelAttribute User user) {
//        userServiceImpl.register(user);
//        return "redirect:/signin?success";
//    }

    @GetMapping ("/signup")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("signup","user",new User());
    }

    @GetMapping("/patients")
    public String getUserLogin (Model model, UserDetails userDetails) {
        String username = userDetails.getUsername();
        return "patient/list";
    }


}
