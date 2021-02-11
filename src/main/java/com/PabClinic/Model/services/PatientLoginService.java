package com.PabClinic.Model.services;

import com.PabClinic.Model.Patient.Patient;
import com.PabClinic.Model.Patient.PatientFabrik;
import com.PabClinic.Model.Patient.PatientLogin;

public class PatientLoginService {

    PatientFabrik patientFabrik = new PatientFabrik();

    public String patientLogin(PatientLogin patientLogin) {
        boolean czyLoginIHasloPasuje = patientFabrik.getPatientsList().stream()
                .filter(patient -> (patientLogin.getLogin().equals(patient.getLogin())
                        || patientLogin.getLogin().equals(patient.getEmail())) &&
                        patientLogin.getPassword().equals(patient.getPassword()))
                .peek(patient -> System.out.println("Udało Ci się zalogować za pomocą hasła i loginu"))
                .findFirst()
                .isPresent();

        if (czyLoginIHasloPasuje) {
            return "redirect:/kalendarz";
        } else {
            return "redirect:/login";
        }
    }




}
