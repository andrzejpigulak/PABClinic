package com.PabClinic.Controller;

import com.PabClinic.Model.Client.ClientContact;
import com.PabClinic.Model.Patient.Patient;
import com.PabClinic.Model.Patient.PatientFabrik;
import com.PabClinic.Model.Patient.PatientLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Component
public class Navigation {

    private final PatientFabrik patientFabrik;

    private final EmailServiceImpl emailService;

    @Autowired
    public Navigation(PatientFabrik patientFabrik, EmailServiceImpl emailService) {
        this.patientFabrik = patientFabrik;
        this.emailService = emailService;
    }

    @GetMapping("/index")
    public String toIndex(Model model) {
        return "redirect:/index";
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
        model.addAttribute("patientContact", new ClientContact());
        return "contact";
    }

    @PostMapping("/contact")
    public String sendMailFromContact(Model Model, @ModelAttribute ClientContact clientContact) {
        emailService.sendSimpleMessage(clientContact.getEmail(), clientContact.getSubject(), "pabclinica@gmail.com", clientContact.getTextMessage(), clientContact.getName());
        System.out.println("wysylam wiadomosc z postmapingu");

        return "redirect:/contact";
    }

    @GetMapping("/login")
    public String toLogin(Model model) {

        model.addAttribute("patientLogin", new PatientLogin());
        return "login";
    }

    @GetMapping("/pageAdmin")
    public String toTest(Model model) {
        return "pageAdmin";
    }

    @GetMapping("/pageDoctor")
    public String toDoctor(Model model) {
        return "pageDoctor";
    }

    @PostMapping("/login")
    public String afterLogin(Model model, @ModelAttribute PatientLogin patientLogin) {

        boolean czyLoginIHasloPasuje = patientFabrik.getPatientsList().stream()
                .filter(patient -> (patientLogin.getLogin().equals(patient.getLogin())
                        || patientLogin.getLogin().equals(patient.getEmail())) &&
                        patientLogin.getPassword().equals(patient.getPassword()))
                .peek(patient -> System.out.println("Udało Ci się zalogować za pomocą hasła i loginu"))
                .findFirst()
                .isPresent();

        if (czyLoginIHasloPasuje) {
            return "redirect:/pageAdmin";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/registration")
    public String toRegistration(Model model) {
        model.addAttribute("patient", new Patient());
        return "registration";
    }

    @PostMapping("/registration")
    public String afterRegistration(Model model, @ModelAttribute Patient patient) {

        patientFabrik.getPatientsList().add(patient);

        patientFabrik.getPatientsList()
                .stream()
                .forEach(System.out::println);

        emailService.sendMessageAfterRegistration(patient.getEmail(), patient.getFirstName(),
                patient.getLogin(), patient.getPassword());


        return "redirect:/login";

    }

    @GetMapping("/privacy_policy")
    public String toPrivacyPolicy(Model model) {
        return "privacy_policy";
    }

}