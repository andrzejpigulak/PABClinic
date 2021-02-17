package com.PabClinic.components.controllers;

import com.PabClinic.components.services.ResearchService;
import com.PabClinic.model.dtos.ClientContactDTO;
import com.PabClinic.components.repositories.ResearchRepository;
import com.PabClinic.components.services.EmailService;
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