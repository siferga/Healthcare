package com.siferga.webapp.service;

import com.siferga.webapp.model.Patient;
import com.siferga.webapp.service.client.PatientFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        return patientFeignClient.createPatient(patient);
    }


    @Override
    public List<Patient> findAllPatients() {
        return patientFeignClient.getAllPatients().getBody();
    }


//    @Override
//    public Patient findPatientByUsername(String firstname) {
//        return patientFeignClient.;
//    }

    public Patient findById(Long id) {
        return patientFeignClient.findPatientById(id).getBody();
    }


    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
        ResponseEntity<Patient> responseEntity = patientFeignClient.findPatientById(id);
            Patient patient = responseEntity.getBody();
            patient.setFirstname(updatedPatient.getFirstname());
            patient.setLastname(updatedPatient.getLastname());
            patient.setBirthday(updatedPatient.getBirthday());
            patient.setEmail(updatedPatient.getEmail());
            patient.setPhone(updatedPatient.getPhone());
            patient.setGender(updatedPatient.getGender());
            patient.setAddress(updatedPatient.getAddress());

        // Save the updated patient back using the Feign client
        return patientFeignClient.createPatient(patient);
    }

    public void deletePatient(Long id) {
        patientFeignClient.deletePatient(id);
    }
}

