package com.pabclinic.controllers;
import com.pabclinic.services.ResearchService;
import com.pabclinic.model.dtos.ClientContactDTO;
import com.pabclinic.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Component
public class Navigation {

    private EmailService emailService;


    private ResearchService researchService;

    @Autowired
    public Navigation(EmailService emailService,ResearchService researchService) {
        this.emailService = emailService;
        this.researchService = researchService;
    }

    @GetMapping("/index")
    public String toIndex() {

        return "index";
    }

    @GetMapping("/patientFramePanel")
    public String toPatientFramePanel(){

        return "patientFramePanel";
    }

    @GetMapping("/doctorFramePanel")
    public String toDoctorFramePanel(){

        return "doctorFramePanel";
    }

    @GetMapping("/adminFramePanel")
    public String toAdminFramePanel(){

        return "adminFramePanel";
    }

    @GetMapping("/services")
    public String toUslugi() {

        return "services";
    }

    @GetMapping("/prices")
    public String toCennik(Model model) {

        model.addAttribute("researchList", researchService.getAllResearches());

        return "prices";
    }

    @GetMapping("/vipatient")
    public String toVipatient() {

        return "vipatient";
    }

    @GetMapping("/pagePatient")
    public String toPatientPage() {

        return "pagePatient";
    }

    @GetMapping("/pageAdmin")
    public String toTest() {

        return "pageAdmin";
    }

    @GetMapping("/privacy_policy")
    public String toPrivacyPolicy() {

        return "privacy_policy";
    }

    @GetMapping("/patientVisitDate")
    public String toPatientVisitDate() {

        return "patientVisitDate";
    }

    @PostMapping("/contact")
    public String sendMailFromContact(@ModelAttribute ClientContactDTO clientContact) {

        emailService.sendSimpleMessage(clientContact.getEmail(), clientContact.getSubject(), "pabclinica@gmail.com", clientContact.getTextMessage(), clientContact.getName());

        return "redirect:/contact";
    }

}