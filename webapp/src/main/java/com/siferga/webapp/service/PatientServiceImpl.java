package com.siferga.webapp.service;

import com.siferga.webapp.model.Patient;
import com.siferga.webapp.service.client.PatientFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final PatientFeignClient patientFeignClient;

    @Override
    public Patient registerPatient (Patient patient) {
        patient.setFirstname(patient.getFirstname());
        patient.setLastname(patient.getLastname());
        patient.setBirthday(patient.getBirthday());
        patient.setEmail(patient.getEmail());
        patient.setPhone(patient.getPhone());
        patient.setGender(patient.getGender());
        patient.setAddress(patient.getAddress());
        return  patientFeignClient.createPatient(patient);
    }
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

