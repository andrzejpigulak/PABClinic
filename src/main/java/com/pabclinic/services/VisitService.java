package com.pabclinic.services;
import com.pabclinic.model.daos.PatientDAO;
import com.pabclinic.repositories.DoctorRepository;
import com.pabclinic.repositories.PatientRepository;
import com.pabclinic.repositories.VisitRepository;
import com.pabclinic.model.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitService {

    private VisitRepository visitRepository;

    private UserLoginDTO userLoginDTO;

    private PatientRepository patientRepository;

    private DoctorRepository doctorRepository;

    private SingleVisitDTO singleVisitDTO;

    private EmailService emailService;

    @Autowired
    public VisitService(VisitRepository visitRepository, UserLoginDTO userLoginDTO, PatientRepository patientRepository, DoctorRepository doctorRepository, SingleVisitDTO singleVisitDTO, EmailService emailService) {
        this.visitRepository = visitRepository;
        this.userLoginDTO = userLoginDTO;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.singleVisitDTO = singleVisitDTO;
        this.emailService = emailService;
    }

    public void addVisit(PatientDAO patientDAO, DoctorDTO doctor){

        visitRepository.addVisitHistory(LocalDate.now().toString(), doctor.getFirstName(), doctor.getLastName(),
                doctor.getLogin(), patientDAO.getFirstName(), patientDAO.getLastName(),
                patientDAO.getOpis());

    }

    public void showDoctorVisitsByDay(Model model) {

        model.addAttribute("visitList", visitRepository.findDoctorVisitsFromUsernameSession());
        model.addAttribute("patient", new PatientDTO());
    }

    public List<VisitTimeDTO> getVisitsTime() {

        return visitRepository.findDoctorVisitsFromDataBase();
    }

    public DoctorDTO findDoctorFromDb(UserLoginDTO userLoginDTO) {

        return visitRepository.findDoctorFromDb(userLoginDTO);

    }

    public List<VisitDTO> findPatientVisits(){

        return visitRepository.findVisitHistory();
    }

    public void registerSingleVisit(DoctorDTO doctorDTO, VisitDTO visitDTO){

        singleVisitDTO.setVisitDate(visitDTO.getVisitDate());
        singleVisitDTO.setDoctorName(doctorRepository.findDoctor(doctorDTO).getFirstName());
        singleVisitDTO.setDoctorLastName(doctorRepository.findDoctor(doctorDTO).getLastName());
        singleVisitDTO.setDoctorUsername(doctorRepository.findDoctor(doctorDTO).getLogin());
        singleVisitDTO.setPatientName(patientRepository.findPatientFromDbByUsername().getFirstName());
        singleVisitDTO.setPatientLastName(patientRepository.findPatientFromDbByUsername().getLastName());
        singleVisitDTO.setPatientUsername(patientRepository.findPatientFromDbByUsername().getUsername());

    }

    public void registerVisit() {

        visitRepository.addVisit();

        emailService.sendMessageAfterRegistrationToAVisit(patientRepository.getEmailFromUsername(), singleVisitDTO.getDoctorName(),
                singleVisitDTO.getDoctorLastName(), singleVisitDTO.getVisitDate(), singleVisitDTO.getVisitTime() );

    }



}
