package com.siferga.webapp.service.client;

import com.siferga.webapp.model.Patient;
import com.siferga.webapp.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "patient")
public interface PatientFeignClient {
//        @PostMapping (value = "/api/createUser", consumes = "application/json")
//    public ResponseEntity<User> createUser(com.siferga.webapp.model.User user);
//
//    @PostMapping(value = "/api/findUserByUsername",consumes = "application/json")
//    public ResponseEntity<User> findUserByUsername(@RequestParam String username);

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user);

    @GetMapping("/findUserByUsername")
    public User findUserByUsername(@RequestParam String email);

    @GetMapping(value = "/api/getAll",consumes = "application/json")
    public ResponseEntity<List<Patient>> getAllPatients();

    @PostMapping(value = "/api/createPatient", consumes = "application/json")
    public String createPatient(Patient patient);

    @PostMapping(value = "/api/findPatientById",consumes = "application/json")
    public ResponseEntity<Patient> findPatientById(@RequestParam Long id);

    @PutMapping(value = "/api/updatePatient",consumes = "application/json")
    public String updatePatient(@RequestParam Long id,Patient patient);

    @DeleteMapping(value = "/api/deletePatient",consumes = "application/json")
    public void deletePatient(@RequestParam Long id);


}







