package com.PabClinic.components.controllers;

import com.PabClinic.components.services.DoctorService;
import com.PabClinic.components.services.VisitService;
import com.PabClinic.model.dtos.*;
import com.PabClinic.model.daos.DoctorDAO;
import com.PabClinic.model.daos.PatientDAO;
import com.PabClinic.components.services.PatientService;
import com.PabClinic.model.daos.VisitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    private PatientDTO singlePatient;

    private PatientService patientService;

    private VisitDTO singleVisit;

    private DoctorDTO singleDoctor;

    private VisitService visitService;

    private DoctorService doctorService;


    @Autowired
    public PatientController(PatientService patientService, VisitService visitService, DoctorService doctorService) {
        this.patientService = patientService;
        this.visitService = visitService;
        this.doctorService = doctorService;

    }

    @GetMapping("/registration")
    public String toRegistration(Model model) {

        model.addAttribute("patient", new PatientDTO());

        return "registration";
    }

    @GetMapping("/login")
    public String toLogin(Model model) {

        model.addAttribute("patientLogin", new PatientLoginDTO());

        return "login";
    }

    @GetMapping("/contact")
    public String toContact(Model model) {

        model.addAttribute("patientContact", new ClientContactDTO());

        return "contact";
    }

    @GetMapping("/testKalendarz")
    public String toTestKalendarz(Model model) {

        model.addAttribute("visitTime", visitService.getVisitsTime());
        model.addAttribute(singleVisit);

        return "testKalendarz";
    }

    @GetMapping("/kalendarz")
    public String toKalendarz(Model model) {

        model.addAttribute("patient", singlePatient);

        model.addAttribute("visit", new VisitDTO());

        model.addAttribute("doctors", doctorService.getAllDoctors());

        model.addAttribute("doctorForm", new DoctorDTO());


        return "kalendarz";
    }

    @PostMapping("/login")
    public String afterLogin(@ModelAttribute PatientLoginDTO patientLogin) {

        return "redirect:/index";
    }


    @GetMapping("/addVisitPatient")
    public String toAddVisitPatient(Model model) {

        visitService.showDoctorVisitsByDay(singleDoctor, model);

        return "addVisitPatient";

    }

    @PostMapping("/addVisitPatient")
    public String afterAddingVisitPatient(@ModelAttribute PatientDAO patient) {

        visitService.addVisit(patient, singleDoctor);

        return "redirect:/addVisitPatient";

    }

    @GetMapping("/patients")
    public String toPatients(Model model) {

        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("patient", new PatientDTO());

        return "patients";
    }

    @GetMapping("/patientEdit")
    public String toPatientEdit(Model model) {

        model.addAttribute("patient", singlePatient);

        return "patientEdit";
    }

    @PostMapping("/registration")
    public String afterRegistration(Model model, @ModelAttribute PatientDTO patient) {

        patientService.registerPatient(patient);

        return "redirect:/login";
    }

    @PostMapping(value = "/kalendarz", params = "saveDate")
    public String saveDate(Model model, @ModelAttribute DoctorDAO doctor,
                           @ModelAttribute VisitDAO visit) {

        // do dodania formularz rejestracji na wizyte

        return "redirect:/testKalendarz";
    }

    @PostMapping(value = "/patients", params = "addPatient")
    public String addPatient(@ModelAttribute PatientDTO patient) {

        patientService.registerPatient(patient);

        return "redirect:/patients";
    }

    @PostMapping(value = "/patients", params = "editPatient")
    public String editPatient(@ModelAttribute PatientDTO patient) {

        singlePatient = patientService.findPatientFromDb(patient);

        return "redirect:/patientEdit";
    }

    @PostMapping(value = "/patients", params = "savePatient")
    public String savePatient(@ModelAttribute PatientDTO patientDTO) {

        patientService.editPatient(patientDTO);

        return "redirect:/patients";
    }

    @PostMapping(value = "/patients", params = "deletePatient")
    public String removePatient(@ModelAttribute PatientDTO patient) {

        patientService.removePatient(patient);

        return "redirect:/patients";
    }
}
