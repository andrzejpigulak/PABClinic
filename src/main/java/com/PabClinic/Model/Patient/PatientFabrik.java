package com.PabClinic.Model.Patient;
import org.springframework.stereotype.Component;


import com.PabClinic.Model.Database.DBPatient;

import java.util.ArrayList;

@Component
public class PatientFabrik {

    private ArrayList<Patient> patientsList = new ArrayList<>();


    public PatientFabrik() {

        DBPatient dbPatient = new DBPatient();
        dbPatient.getPatients(patientsList);
    }

    public ArrayList<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(ArrayList<Patient> patientsList) {
        this.patientsList = patientsList;
    }
}
