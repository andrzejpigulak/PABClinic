package com.PabClinic.components.services;
import com.PabClinic.model.daos.PatientDAO;
import com.PabClinic.components.repositories.PatientRepository;
import com.PabClinic.model.dtos.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    private EmailService emailService;

    @Autowired
    public PatientService(PatientRepository patientRepository, EmailService emailService) {
        this.patientRepository = patientRepository;
        this.emailService = emailService;
    }

    public void registerPatient(PatientDTO patient){

        patientRepository.addPatient(patient);

        emailService.sendMessageAfterRegistration(patient.getEmail(), patient.getFirstName(), patient.getLogin(), patient.getPassword());

    }

    public void removePatient(PatientDTO patient){

        patientRepository.removePatient(patient);

    }

    public List<PatientDTO> getAllPatients(){

        return patientRepository.getPatients();

    }

    public void editPatient(PatientDTO patientDTO) {

        patientRepository.updatePatient(patientDTO);
    }

    public PatientDTO findPatientFromDb(PatientDTO patientDTO) {

        return patientRepository.findPatientFromDb(patientDTO);
    }

}
