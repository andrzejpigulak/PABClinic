package com.PabClinic.components.controllers;
import com.PabClinic.components.services.DoctorService;
import com.PabClinic.components.services.VisitService;
import com.PabClinic.model.daos.PatientDAO;
import com.PabClinic.model.dtos.DoctorDTO;
import com.PabClinic.model.dtos.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoctorController {

    private DoctorService doctorService;

    private VisitService visitService;

    private UserLoginDTO userLoginDTO;


    @Autowired
    public DoctorController(DoctorService doctorService, VisitService visitService, UserLoginDTO userLoginDTO) {
        this.doctorService = doctorService;
        this.visitService = visitService;
        this.userLoginDTO = userLoginDTO;
    }

    @GetMapping("/doctors")
    public String toDoctors(Model model) {

        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("doctor", new DoctorDTO());

        return "doctors";
    }

    @GetMapping("/pageDoctor")
    public String toDoctor() {



        return "pageDoctor";
    }

    @PostMapping("/login")
    public String afterLogin() {


        return "redirect:/index";
    }

    @GetMapping("/addVisitPatient")
    public String toAddVisitPatient(Model model) {

        visitService.showDoctorVisitsByDay(model);

        return "addVisitPatient";

    }

    @PostMapping("/addVisitPatient")
    public String afterAddingVisitPatient(@ModelAttribute PatientDAO patient) {

        visitService.addVisit(patient, visitService.findDoctorFromDb(userLoginDTO));

        return "redirect:/addVisitPatient";

    }






}
