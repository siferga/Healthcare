package com.siferga.webapp.model;

import lombok.*;

import java.time.LocalDate;

//@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Long patientid;
    private String firstname;
    private String lastname;
    private String gender;
    private LocalDate birthday;
    private String address;
    private String phone;
    private String email;

}

