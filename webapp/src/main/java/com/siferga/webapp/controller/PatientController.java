package com.siferga.webapp.controller;

import ch.qos.logback.core.model.Model;
import com.siferga.webapp.model.Patient;
import com.siferga.webapp.service.PatientServiceImpl;
import com.siferga.webapp.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class PatientController {
    private final PatientServiceImpl patientServiceImpl;
    private final UserServiceImpl userServiceImpl;


    /*************************   ADD PATIENT   *****************************/

    @PostMapping("/addPatient")
    public ModelAndView addNewPatient(@ModelAttribute Patient patient) {
        patientServiceImpl.registerPatient(patient);
        return new ModelAndView("/patientList","patient",new Patient());
    }


    /*************************   PATIENT LIST   *****************************/

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
//    @GetMapping("/findAll")
//    public List<Patient> getAllPatients(@RequestBody Patient patient) {
//        return patientServiceImpl.findAllPatients();
//    }

    @PostMapping("/patientList")
    public ModelAndView showPatientList(@ModelAttribute Patient patient) {
        List<Patient> patients = patientServiceImpl.findAllPatients();
        ModelAndView modelAndView = new ModelAndView("patientList");
        modelAndView.addObject("patients", patients);
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @GetMapping("/patientList")
    public ModelAndView showPatientList(Model model) {
        List<Patient> patients = patientServiceImpl.findAllPatients();
        ModelAndView modelAndView = new ModelAndView("patientList");
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientServiceImpl.findAllPatients();
        return ResponseEntity.ok(patients);
    }




//    @GetMapping("/patientList")
//    public String showPatientList(Model model) {
//        List<Patient> patients = patientServiceImpl.findAll();
//        model.addAttribute("patients", patients);
//        return "patientList"; // Name of the Thymeleaf template
//    }


    /*************************   FIND A PATIENT   *****************************/


//    @PostMapping("/findPatientByUsername")
//    public Patient findPatientByUsername(@RequestParam Patient patient) {
//        return patientServiceImpl.findPatientByUsername();
//    }


    /*************************   UPDATE A PATIENT   *****************************/

    @GetMapping ("/updatePatient")
    public ModelAndView updatePatient() {
        return new ModelAndView("/updatePatient");
    }

    @GetMapping("/updatePatient/{id}")
    public ModelAndView showUpdatePatientForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("updatePatient");
        Patient patient = patientServiceImpl.findById(id);
        if (patient == null) {
            modelAndView.setViewName("redirect:/patientList");
            return modelAndView;
        }
        modelAndView.addObject("patient", patient);
        return modelAndView;
    }

//    @PostMapping("/updatePatient/{id}")
//    public ModelAndView updatePatient(@PathVariable("id") Long id, @ModelAttribute("patient") Patient patient) {
//        ModelAndView modelAndView = new ModelAndView("updatePatient");
//        patientServiceImpl.updatePatient(id,patient);
//        modelAndView.setViewName("redirect:/patientDetail");
//        return modelAndView;
//    }


}
