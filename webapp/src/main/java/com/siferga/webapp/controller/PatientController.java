package com.siferga.webapp.controller;

import ch.qos.logback.core.model.Model;
import com.siferga.webapp.model.Patient;
import com.siferga.webapp.service.PatientServiceImpl;
import com.siferga.webapp.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class PatientController {
    private final PatientServiceImpl patientServiceImpl;
    private final UserServiceImpl userServiceImpl;


    /*************************   ADD PATIENT   *****************************/

    @GetMapping ("/addPatient")
    public ModelAndView showAddPatientForm() {
        return new ModelAndView("/patients/addPatient","patient",new Patient());
    }

    @PostMapping("/addPatient")
    public ModelAndView addNewPatient(@ModelAttribute Patient patient) {
        patientServiceImpl.registerPatient(patient);
        return new ModelAndView("/patients/patientList","patient",new Patient());
    }


  /***********   PATIENT LIST   *****************************/

//    @PostMapping("/patientList")
//    public ModelAndView showPatientList(@ModelAttribute Patient patient) {
//        patientServiceImpl.findAllPatients();
//        return new ModelAndView("/patientList","patient",new Patient());
//    }
//
//    @GetMapping("/patientList")
//    public ModelAndView showPatientList(Model model, UserDetails userDetails) {
//        //String username = userDetails.getUsername();
//        patientServiceImpl.findAllPatients();
//        return new ModelAndView("/patientList");
//    }
//

    @GetMapping("/patientList")
    public ModelAndView showPatientList(Model model) {
        List<Patient> patients = patientServiceImpl.findAllPatients();
        return new ModelAndView("patients/patientList", "patients", patients);
    }

    @PostMapping("/patientList")
    public ModelAndView showPatientList(@ModelAttribute Patient patient) {
        List<Patient> patients = patientServiceImpl.findAllPatients();
        ModelAndView modelAndView = new ModelAndView("patients/patientList");
        modelAndView.addObject("patients", patients);
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientServiceImpl.findAllPatients();
        return ResponseEntity.ok(patients);
    }

    //    @GetMapping("/findAll")
//    public List<Patient> getAllPatients(@RequestBody Patient patient) {
//        return patientServiceImpl.findAllPatients();
//    }

    /*************************   FIND A PATIENT   *****************************/

    //getting users byID
    @PostMapping("findPatientById")
    public Patient getPatientById(@RequestParam Long id) {
        return this.patientServiceImpl.findById(id);
    }

    /*************************   UPDATE A PATIENT   *****************************/

    @GetMapping ("/updatePatient/{id}")
    public ModelAndView updatePatient(@PathVariable Long id) {
        return new ModelAndView("/patients/patientList","patient",patientServiceImpl.findById(id));
    }

    // Handle form submission for updating a specific patient
    @PostMapping("/updatePatient/{id}")
    public ModelAndView updatePatient(@PathVariable("id") Long id, @ModelAttribute("patient") Patient patient) {
        patientServiceImpl.updatePatient(id, patient);
        return new ModelAndView ("/patients/updatePatient");
    }

    /*************************   DELETE A PATIENT   *****************************/

    // Show form for deleting a specific patient
    @GetMapping("/deletePatient/{id}")
    public ModelAndView showDeletePatientForm(@PathVariable("id") Long id) {
        return new ModelAndView("/patients/deletePatient","patient",patientServiceImpl.findById(id));
    }

    // Deleting a patient
    @PostMapping("/deletePatient/{id}")
    public ModelAndView deletePatient(@PathVariable("id") Long id, @ModelAttribute("patient") Patient patient) {
        patientServiceImpl.deletePatient(id);
        return new ModelAndView("/patients/patientList");
    }
//    @DeleteMapping("/patients/deletePatient")
//    public ModelAndView deletePatient(@RequestParam("id") Long id) {
//        patientServiceImpl.deletePatient(id);
//        return new ModelAndView("redirect:patients/patientList");
//    }


}
