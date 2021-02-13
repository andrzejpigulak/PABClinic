package com.PabClinic.Controller;

import com.PabClinic.Model.Client.ClientContact;
import com.PabClinic.Model.Database.DataBase;
import com.PabClinic.Model.Doctor.Doctor;
import com.PabClinic.Model.Doctor.DoctorDAO;
import com.PabClinic.Model.Doctor.DoctorForm;
import com.PabClinic.Model.Patient.Patient;
import com.PabClinic.Model.Patient.PatientFabrik;
import com.PabClinic.Model.Patient.PatientLogin;
import com.PabClinic.Model.Research.Research;
import com.PabClinic.Model.Research.ResearchFabrik;
import com.PabClinic.Model.Visit.Visit;
import com.PabClinic.Model.Visit.VisitFabrik;
import com.PabClinic.Model.Visit.VisitHistory;
import com.PabClinic.Model.services.PatientRegistrationService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
@Component
public class Navigation {

    private final VisitFabrik visitFabrik = new VisitFabrik();

    private Visit singleVisit;

    private final EmailServiceImpl emailService;

    private Patient singlePatient;

    private Doctor singleDoctor;

    private PatientRegistrationService patientRegistrationService = new PatientRegistrationService();

    PatientFabrik patientFabrik = new PatientFabrik();
    DoctorForm doctorFabrik = new DoctorForm();

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

        DoctorForm doctorFabrik = new DoctorForm();

        model.addAttribute("doctorList", doctorFabrik);
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

        boolean czyLoginIHasloPasuje = patientFabrik.getPatientsList().stream()
                .filter(patient -> (patientLogin.getLogin().equals(patient.getLogin())
                        || patientLogin.getLogin().equals(patient.getEmail())) &&
                        patientLogin.getPassword().equals(patient.getPassword()))
                .peek(patient -> singlePatient = patient)
                .peek(patient -> System.out.println(singlePatient))
                .peek(patient -> System.out.println("Udało Ci się zalogować za pomocą hasła i loginu"))
                .findFirst()
                .isPresent();

//        boolean czyLoginIHasloPasujeDoctor = doctorFabrik.getDoctorList().stream()
//                .filter(doctor -> (patientLogin.getLogin().equals(doctor.getLogin())
//                        && (patientLogin.getPassword().equals(doctor.getPassword()))))
//                .peek(doctor -> singleDoctor = doctor)
//                .findFirst()
//                .isPresent();

        if (czyLoginIHasloPasuje) {
            return "redirect:/kalendarz";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/registration")
    public String afterRegistration(Model model, @ModelAttribute Patient patient) {

//        DataBase dataBase = new DataBase();
//
//        dataBase.registerPatient(patient);
//


        patientRegistrationService.zarejestrujPacjenta(patient);

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

    @PostMapping(value = "/patientList", params = "editPatient")
    public String editPatient(Model model, @ModelAttribute Patient patient) {

        singlePatient = new DataBase().editPatient(patient);

        return "redirect:/patientEdit";
    }

    @GetMapping("/patientEdit")
    public String toPatientEdit(Model model) {

        model.addAttribute("patient", singlePatient);

        return "patientEdit";
    }

    @GetMapping("/addVisitPatient")
    public String toAddVisitPatient(Model model) {


        ArrayList<Visit> wizytyDoktora = new ArrayList<>();
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.toString());

        for (Visit visit : visitFabrik.getVisitsList()) {
            if (visit.getDateVisit().equals(localDate.toString()) || singleDoctor.equals(visit.getDoctor())) {
                wizytyDoktora.add(visit);
            }

            model.addAttribute("visitList", wizytyDoktora);
            model.addAttribute("patient", new Patient());


        }

        return "addVisitPatient";

    }

    @PostMapping("/addVisitPatient")
    public String afterAddingVisitPatient(@ModelAttribute Patient patient) {


        for (Patient p : patientFabrik.getPatientsList()) {
            if (p.getFirstName().equals(patient.getFirstName()) && p.getLastName().equals(patient.getLastName())) {
                p.getVisitHistory().add(new VisitHistory(LocalDate.now().toString(), singleDoctor, patient.getOpis()));
                System.out.println(p.getVisitHistory().toString());
            }
        }


        return "redirect:/addVisitPatient";

    }

    @GetMapping("/patientVisitDate")
    public String toPatientVisitDate(Model model) {

        return "patientVisitDate";
    }

    @GetMapping("/kalendarz")
    public String toKalendarz(Model model) {

        DoctorForm form = new DoctorForm();
        model.addAttribute("doctorForm", form);

        model.addAttribute("patient", singlePatient);

        model.addAttribute("visit", new Visit());

        DoctorDAO doctorDAO = new DoctorDAO();
        List<Doctor> list = doctorDAO.getDoctors();

        model.addAttribute("doctors", list);
        System.out.println(list);

        return "kalendarz";
    }

    @GetMapping("/doctorEdit")
    public String toDoctorEdit(Model model) {

        model.addAttribute("doctor", singleDoctor);

        return "doctorEdit";
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

    @RequestMapping(value = "/doctorList", params = "saveDoctor", method = RequestMethod.POST)
    public String saveDoctor(Model model, @ModelAttribute Doctor doctor) {

        new DataBase().updateDoctor(doctor);

        return "redirect:/doctorList";
    }

    @GetMapping("/testKalendarz")
    public String toTestKalendarz(Model model) {
        model.addAttribute("visitTime", visitFabrik.getVisitTime());
        model.addAttribute(singleVisit);

        return "testKalendarz";
    }


    @RequestMapping(value = "/kalendarz", params = "saveDate", method = RequestMethod.POST)
    public String saveDate(Model model, @ModelAttribute Doctor doctor,
                           @ModelAttribute Visit visit, @ModelAttribute DoctorForm doctorFabrik) {

        visit.setPatient(singlePatient);

        visit.setDoctor(doctor);

        System.out.println("WYBIERAM DOKTORA " + doctor.getDoctor_ID() + doctor.getLastName());
        visit.setDateVisit(visit.getDateVisit());
        singleVisit = visit;
        visitFabrik.addVisitToList(visit);
        VisitFabrik dodajeGodzinyWizyt = new VisitFabrik();


        for (Visit wizytatest : visitFabrik.getVisitTime()) {
            System.out.println(wizytatest);
        }

        System.out.println(singleVisit);

        for (Visit wizyta : visitFabrik.getVisitsList()) {
            for (Visit wizytaCzas : visitFabrik.getVisitTime()) {
                if (singleVisit.getDoctor().equals(wizyta.getDoctor())
                        && singleVisit.getDateVisit().equals(wizyta.getDateVisit())
                        && wizytaCzas.getTimeVisit().equals(wizyta.getTimeVisit())
                ) {
                    visitFabrik.usunGodzine(wizytaCzas);
                }
            }
        }

        for (Visit wizytatest : visitFabrik.getVisitTime()) {
            System.out.println(wizytatest);
        }

        // musimy dodac przykladowe wizyty z konkretnymi lekarzami do listy wizyt,
        // trzeba dodac mozliwosc zapisywania lekarzy
        // sprawdzic czy dziala

        return "redirect:/testKalendarz";
    }

}