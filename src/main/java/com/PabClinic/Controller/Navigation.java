package com.PabClinic.Controller;

import com.PabClinic.Model.Patient;
import com.PabClinic.Model.PatientFabrik;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Navigation {

    PatientFabrik patientFabrik = new PatientFabrik();

    @GetMapping("/index")
    public String toIndex(Model model) {
        return "index";
    }

    @GetMapping("/services")
    public String toUslugi(Model model) {
        return "services";
    }

    @GetMapping("/prices")
    public String toCennik(Model model) {
        return "prices";
    }

    @GetMapping("/vipatient")
    public String toVipatient(Model model) {
        return "vipatient";
    }

    @GetMapping("/contact")
    public String toContact(Model model) {
        return "contact";
    }

    @GetMapping("/registration")
    public String toRegistration(Model model) {
        model.addAttribute("patient", new Patient());
        return "registration";
    }

    @PostMapping("/registration")
    public String afterRegistration(Model model, @ModelAttribute Patient patient) {
        patientFabrik.getPatientsList().add(patient);

        return "redirect:/login";

    }
}
