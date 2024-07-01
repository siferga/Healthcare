package com.siferga.webapp.model;

import lombok.*;

import java.time.LocalDate;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String email;
    private String phone;
    private String gender;
    private String address;

}

