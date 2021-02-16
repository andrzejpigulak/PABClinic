package com.PabClinic.components.controllers;
import com.PabClinic.components.repositories.VisitRepository;
import com.PabClinic.components.services.DoctorService;
import com.PabClinic.components.services.VisitService;
import com.PabClinic.model.dtos.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {

    private DoctorService doctorService;

    private VisitService visitService;

    @Autowired
    public DoctorController(DoctorService doctorService, VisitService visitService) {
        this.doctorService = doctorService;
        this.visitService = visitService;
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






}
