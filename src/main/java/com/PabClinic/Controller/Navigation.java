package com.PabClinic.Controller;

import com.PabClinic.Model.Client.ClientContact;
import com.PabClinic.Model.Database.DataBase;
import com.PabClinic.Model.Doctor.Doctor;
import com.PabClinic.Model.Doctor.DoctorFabrik;
import com.PabClinic.Model.Patient.Patient;
import com.PabClinic.Model.Patient.PatientFabrik;
import com.PabClinic.Model.Patient.PatientLogin;
import com.PabClinic.Model.Research.Research;
import com.PabClinic.Model.Research.ResearchFabrik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Component
public class Navigation {

    private final PatientFabrik patientFabrik;

    private final EmailServiceImpl emailService;

    private Patient singlePatient;

    private Doctor singleDoctor;

    @Autowired
    public Navigation(PatientFabrik patientFabrik, EmailServiceImpl emailService) {

        this.patientFabrik = patientFabrik;
        this.emailService = emailService;
    }

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

        ResearchFabrik researchFabrik = new ResearchFabrik();

        model.addAttribute("researchList", researchFabrik.getResearchList());

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

    @GetMapping("/doctorList")
    public String toDoctorList(Model model) {

        DoctorFabrik doctorFabrik = new DoctorFabrik();

        model.addAttribute("doctorList", doctorFabrik.getDoctorList());
        model.addAttribute("doctor", new Doctor());

        return "doctorList";
    }

    @GetMapping("/registration")
    public String toRegistration(Model model) {

        model.addAttribute("patient", new Patient());

        return "registration";
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

    @GetMapping("/patientList")
    public String toPatientList(Model model) {

        PatientFabrik patientFabrik = new PatientFabrik();

        model.addAttribute("patientList", patientFabrik.getPatientsList());
        model.addAttribute("patient", new Patient());

        return "patientList";
    }

    @GetMapping("/privacy_policy")
    public String toPrivacyPolicy(Model model) {

        return "privacy_policy";
    }

    @GetMapping("/researchList")
    public String toResearchList(Model model) {

        ResearchFabrik researchFabrik = new ResearchFabrik();

        model.addAttribute("noweBadanie", new Research());
        model.addAttribute("researchList", researchFabrik.getResearchList());

        return "researchList";
    }

    @PostMapping("/contact")
    public String sendMailFromContact(Model Model, @ModelAttribute ClientContact clientContact) {

        emailService.sendSimpleMessage(clientContact.getEmail(), clientContact.getSubject(), "pabclinica@gmail.com", clientContact.getTextMessage(), clientContact.getName());

        return "redirect:/contact";
    }

    @PostMapping("/login")
    public String afterLogin(Model model, @ModelAttribute PatientLogin patientLogin) {

        PatientFabrik patientFabrik = new PatientFabrik();

        boolean czyLoginIHasloPasuje = patientFabrik.getPatientsList().stream()
                .filter(patient -> (patientLogin.getLogin().equals(patient.getLogin())
                        || patientLogin.getLogin().equals(patient.getEmail())) &&
                        patientLogin.getPassword().equals(patient.getPassword()))
                .peek(patient -> singlePatient = patient)
                .peek(patient -> System.out.println(singlePatient))
                .peek(patient -> System.out.println("Udało Ci się zalogować za pomocą hasła i loginu"))
                .findFirst()
                .isPresent();

        if (czyLoginIHasloPasuje) {
            return "redirect:/kalendarz";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/registration")
    public String afterRegistration(Model model, @ModelAttribute Patient patient) {

        DataBase dataBase = new DataBase();

        dataBase.registerPatient(patient);

        emailService.sendMessageAfterRegistration(patient.getEmail(), patient.getFirstName(),
                patient.getLogin(), patient.getPassword());

        return "redirect:/login";
    }

    @RequestMapping(value = "/patientList", params = "deletePatient", method = RequestMethod.POST)
    public String removePatient(Model model, @ModelAttribute Patient patient) {

        new DataBase().removePatient(patient);

        return "redirect:/patientList";
    }

    @RequestMapping(value = "/patientList", params = "addPatient", method = RequestMethod.POST)
    public String addPatient(Model model, @ModelAttribute Patient patient) {

        DataBase dataBase = new DataBase();

        dataBase.registerPatient(patient);

        emailService.sendMessageAfterRegistration(patient.getEmail(), patient.getFirstName(),
                patient.getLogin(), patient.getPassword());

        return "redirect:/patientList";
    }

    @RequestMapping(value = "/patientList", params = "editPatient", method = RequestMethod.POST)
    public String editPatient(Model model, @ModelAttribute Patient patient) {

        singlePatient = new DataBase().editPatient(patient);

        return "redirect:/patientEdit";
    }

    @GetMapping("/patientEdit")
    public String toPatientEdit(Model model) {

        model.addAttribute("patient", singlePatient);

        return "patientEdit";
    }

    @RequestMapping(value = "/patientList", params = "savePatient", method = RequestMethod.POST)
    public String savePatient(Model model, @ModelAttribute Patient patient) {

        new DataBase().updatePatient(patient);

        return "redirect:/patientList";
    }

    @RequestMapping(value = "/doctorList", params = "addDoctor", method = RequestMethod.POST)
    public String addDoctor(Model model, @ModelAttribute Doctor doctor) {

        DataBase dataBase = new DataBase();

        dataBase.registerDoctor(doctor);

        return "redirect:/doctorList";
    }

    @RequestMapping(value = "/doctorList", params = "deleteDoctor", method = RequestMethod.POST)
    public String removeDoctor(Model model, @ModelAttribute Doctor doctor) {

        new DataBase().removeDoctor(doctor);

        return "redirect:/doctorList";
    }

    @RequestMapping(value = "/doctorList", params = "editDoctor", method = RequestMethod.POST)
    public String editDoctor(Model model, @ModelAttribute Doctor doctor) {

        singleDoctor = new DataBase().editDoctor(doctor);

        return "redirect:/doctorEdit";
    }

    @GetMapping("/doctorEdit")
    public String toDoctorEdit(Model model) {

        model.addAttribute("doctor", singleDoctor);

        return "doctorEdit";
    }

    @RequestMapping(value = "/doctorList", params = "saveDoctor", method = RequestMethod.POST)
    public String saveDoctor(Model model, @ModelAttribute Doctor doctor) {

        new DataBase().updateDoctor(doctor);

        return "redirect:/doctorList";
    }

    @GetMapping("/patientVisitDate")
    public String toPatientVisitDate(Model model) {
        return "patientVisitDate";
    }

    @GetMapping("/kalendarz")
    public String toKalendarz(Model model) {

        model.addAttribute("patient", singlePatient);

        return "kalendarz";
    }

    @RequestMapping(value = "/kalendarz", params = "saveDate", method = RequestMethod.POST)
    public String saveDate(Model model, @ModelAttribute Patient patient) {

        System.out.println(singlePatient);
        singlePatient.setDatePick(patient.getDatePick());
        System.out.println(singlePatient);


        return "redirect:/kalendarz";
    }

}