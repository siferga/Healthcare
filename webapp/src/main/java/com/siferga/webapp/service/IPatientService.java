package com.siferga.webapp.service;

import com.siferga.webapp.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatientService {
    public Patient registerPatient(Patient patient);
    public List<Patient> findAllPatients();
   // public Patient getPatientById(Long id);
    //Patient findPatientByUsername(String firstname);
    public Patient updatePatient(Long id, Patient updatedPatient);
    //Patient findPatientByUsername(String firstname);
    //public Patient addPatient(Patient patient);




}
