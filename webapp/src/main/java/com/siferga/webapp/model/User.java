package com.siferga.webapp.model;

//il faut le pousser par feign
//USER DANS LE MODEL

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String password;
    // Example of Role enum, you can customize it as per your requirement
    public enum Role {
        ADMIN, USER, GUEST
    }

 }


//    @Enumerated(Enum)
//userdto dans le patient
//    mapping dans la couche service
