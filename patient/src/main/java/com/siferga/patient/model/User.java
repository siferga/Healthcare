package com.siferga.patient.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String username;
    private String password;

//    @Enumerated(EnumTy)
//    private String num<Role>;
//userdto dans le patient
    //mapping dans la couche service
}

