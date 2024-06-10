package com.siferga.webapp.service;

import com.siferga.webapp.model.Patient;
import com.siferga.webapp.model.User;
import com.siferga.webapp.service.client.PatientFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final PasswordEncoder passwordEncoder;
    private final PatientFeignClient patientFeignClient;

    @Override
    public List<Patient> getAllPatients() {
        return List.of();
    }

    @Override
    public Patient findPatientByName(String patientName) {
        return null;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return null;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return null;
    }

//    @Override
//    public Patient createUser(Patient patient) {
//        return null;
//    }
//
//    @Override
//    public User register(User user) {
//        //user.setRole(UserRole.USER);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return  patientFeignClient.createUser(user);
//
//    }
//
//    @Override
//    public User findByUserName(String username) {
//        return patientFeignClient.findUserByUsername(username);
//    }

}

