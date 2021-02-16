package com.PabClinic.components.services;
import com.PabClinic.model.daos.PatientDAO;
import com.PabClinic.components.repositories.VisitRepository;
import com.PabClinic.model.dtos.DoctorDTO;
import com.PabClinic.model.dtos.PatientDTO;
import com.PabClinic.model.dtos.VisitTimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitService {

    private VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public void addVisit(PatientDAO patientDAO, DoctorDTO doctor){

        visitRepository.addVisitHistory(LocalDate.now().toString(), doctor.getFirstName(), doctor.getLastName(), patientDAO.getFirstName(), patientDAO.getLastName(),
                patientDAO.getOpis());

    }

    public void showDoctorVisitsByDay(DoctorDTO doctor, Model model) {

        model.addAttribute("visitList", visitRepository.findDoctorVisits(doctor));
        model.addAttribute("patient", new PatientDTO());
    }

    public List<VisitTimeDTO> getVisitsTime() {

        return visitRepository.getVisitsTime();
    }

}
