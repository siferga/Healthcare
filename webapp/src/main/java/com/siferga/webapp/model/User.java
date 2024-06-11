package com.siferga.webapp.model;

//il faut le pousser par feign
//USER DANS LE MODEL

import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userid;
    private String email;
    private String password;
    //private Enum role;

 }


//    @Enumerated(Enum)
//userdto dans le patient
//    mapping dans la couche service
