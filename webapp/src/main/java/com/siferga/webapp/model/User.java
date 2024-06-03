package com.siferga.webapp.model;

//il faut le pousser par feign
//USER DANS LE MODEL
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
    private String email;
    private String password;


//    @Enumerated(EnumTy)
//    private String num<Role>;
//userdto dans le patient
    //mapping dans la couche service
}
