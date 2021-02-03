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
        System.out.println("wysylam wiadomosc z postmapingu");

        return "redirect:/contact";
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

    @PostMapping("/registration")
    public String afterRegistration(Model model, @ModelAttribute Patient patient) {

        DataBase dbPatient = new DataBase();

        dbPatient.registerPatient(patient);

//        patientFabrik.getPatientsList()
//                .stream()
//                .forEach(System.out::println);

        emailService.sendMessageAfterRegistration(patient.getEmail(), patient.getFirstName(),
                patient.getLogin(), patient.getPassword());


        return "redirect:/login";

    }

    @PostMapping("/patientList")
    public String removePatient(Model model, @ModelAttribute Patient patient) {

        DataBase db = new DataBase();
        PatientFabrik patientFabrik = new PatientFabrik();

        for (Patient p : patientFabrik.getPatientsList()) {
            if (patient.getUser_id() == p.getUser_id()) {
                db.removePatient(patient);
            }
        }

        return "redirect:/patientList";

    }
}