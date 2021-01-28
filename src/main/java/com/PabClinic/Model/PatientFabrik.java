package com.PabClinic.Model;
import com.PabClinic.Model.Database.DBPatient;

import java.util.ArrayList;

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
