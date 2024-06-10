package com.siferga.patient.controller;

import com.siferga.patient.model.Patient;
import com.siferga.patient.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Create a new patient
    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    // Get all patients
    @GetMapping("/getAll")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    // Get a single patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer id) {
        Optional<Patient> patient = patientService.findById(id);
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer patientId, @RequestBody Patient patientDetails) {
        Optional<Patient> patientOptional = patientService.findById(patientId);
        if (!patientOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Patient patient = patientOptional.get();
        patient.setFirstname(patientDetails.getFirstname());
        patient.setLastname(patientDetails.getLastname());
        patient.setGender(patientDetails.getGender());
        patient.setBirthday(patientDetails.getBirthday());
        patient.setAddress(patientDetails.getAddress());
        patient.setPhone(patientDetails.getPhone());
        patient.setEmail(patientDetails.getEmail());
        Patient updatedPatient = patientService.save(patient);
        return ResponseEntity.ok(updatedPatient);
    }

    // Delete a patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer id) {
        Optional<Patient> patientOptional = patientService.findById(id);
        if (!patientOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        patientService.delete(patientOptional.get());
        return ResponseEntity.noContent().build();
    }
}



