package com.siferga.webapp.controller;

import ch.qos.logback.core.model.Model;
import com.siferga.webapp.model.Patient;
import com.siferga.webapp.service.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatientController {
    private final PatientServiceImpl patientServiceImpl;

    @PostMapping("/addPatient")
    public ModelAndView addPatientForm(@ModelAttribute Patient patient) {
        patientServiceImpl.registerPatient(patient);
        return new ModelAndView("/patientList","patient",new Patient());
    }

    @GetMapping ("/updatePatient")
    public ModelAndView updatePatient() {
        return new ModelAndView("/updatePatient");
    }
    // Create a new patient

    @GetMapping("/patientList")
    public String getUserLogin (Model model, UserDetails userDetails) {
        String username = userDetails.getUsername();
        return "patient/list";
    }

}
