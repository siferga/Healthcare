package com.siferga.patient.service;

import com.siferga.patient.model.Patient;
import com.siferga.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public String updatePatient(Long id, Patient patient) {
        patientRepository.findById(id).get().getEmail().equals(patient.getEmail());
        patientRepository.save(patient);
        return "Patient updated";

    }
        public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
