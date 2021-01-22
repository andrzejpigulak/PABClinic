package com.PabClinic.Controller;

import com.PabClinic.Model.ClinetContact;
import com.PabClinic.Model.Patient;
import com.PabClinic.Model.PatientFabrik;
import com.PabClinic.Model.PatientLogin;
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
        model.addAttribute("patientContact", new ClinetContact());
        return "contact";
    }

    @GetMapping("/login")
    public String toLogin(Model model) {
        model.addAttribute("patientLogin", new PatientLogin());
        return "login";
    }

    @GetMapping("/test")
    public String toTest(Model model) {
        return "test";
    }

    @PostMapping("/login")
    public String afterLogin(Model model, @ModelAttribute PatientLogin patientLogin) {

        findPatientFromLogin(model, patientLogin);
        findPatientFromEmail(model, patientLogin);
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String toRegistration(Model model) {
        model.addAttribute("patient", new Patient());
        return "registration";
    }

    @PostMapping("/registration")
    public String afterRegistration(Model model, @ModelAttribute Patient patient) {
        patientFabrik.getPatientsList().add(patient);
        for (Patient p : patientFabrik.getPatientsList()) {
            System.out.println(p);
        }

        return "redirect:/login";

    }

    private String findPatientFromLogin(Model model, @ModelAttribute PatientLogin patientLogin) {

        for (Patient p : patientFabrik.getPatientsList()) {
            if (patientLogin.getLogin().equals(p.getLogin())) {
                System.out.println("Login pasuje");
                if (patientLogin.getPassword().equals(p.getPassword())) {
                    System.out.println("Login i hasło pasuje");
                    return "redirect:/test";
                }
            }
        }
        return "redirect:/login";
    }

    private String findPatientFromEmail(Model model, @ModelAttribute PatientLogin patientLogin) {

        for (Patient p : patientFabrik.getPatientsList()) {
            if (patientLogin.getLogin().equals(p.getEmail())) {
                System.out.println("Email pasuje");
                if (patientLogin.getPassword().equals(p.getPassword())) {
                    System.out.println("Email i hasło pasuje");
                    return "redirect:/test";
                }
            }
        }
        return "redirect:/login";
    }

}
