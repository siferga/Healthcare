package com.siferga.webapp.service;

import com.siferga.webapp.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatientService {
    public List<Patient> getAllPatients();
    public Patient findPatientByName(String patientName);
    public Patient addPatient(Patient patient);
    public Patient updatePatient(Patient patient);
}
