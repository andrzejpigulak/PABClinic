package com.PabClinic.components.services;
import com.PabClinic.model.daos.PatientDAO;
import com.PabClinic.components.repositories.VisitRepository;
import com.PabClinic.model.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitService {

    private VisitRepository visitRepository;

    private UserLoginDTO userLoginDTO;

    @Autowired
    public VisitService(VisitRepository visitRepository, UserLoginDTO userLoginDTO) {
        this.visitRepository = visitRepository;
        this.userLoginDTO = userLoginDTO;
    }

    public void addVisit(PatientDAO patientDAO, DoctorDTO doctor){

        visitRepository.addVisitHistory(LocalDate.now().toString(), doctor.getFirstName(), doctor.getLastName(),
                doctor.getLogin(), patientDAO.getFirstName(), patientDAO.getLastName(),
                patientDAO.getOpis());

    }

    public void showDoctorVisitsByDay(UserLoginDTO userLoginDTO, Model model) {

        model.addAttribute("visitList", visitRepository.findDoctorVisits(userLoginDTO));
        model.addAttribute("patient", new PatientDTO());
    }

    public List<VisitTimeDTO> getVisitsTime() {

        return visitRepository.getVisitsTime();
    }

    public DoctorDTO findDoctorFromDb(UserLoginDTO userLoginDTO) {

        return visitRepository.findDoctorFromDb(userLoginDTO);

    }

    public List<VisitDTO> findPatientVisits(){

        return visitRepository.findVisitHistory();
    }

}
