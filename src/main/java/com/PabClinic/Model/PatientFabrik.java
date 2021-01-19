package com.PabClinic.Model;

import java.util.ArrayList;

public class PatientFabrik {

    private ArrayList<Patient> patientsList = new ArrayList<>();


    public PatientFabrik() {
        patientsList.add(new Patient("Adam", "Kowalski", 87110725732L, "akowalski", "akowalski@mail.com", 627315621, "ul. Marszalkowska 12", "61-001", "Poznań"));
        patientsList.add(new Patient("Katarzyna", "Sikora", 67032265927L, "ksikora", "akowalski@mail.com", 504213521, "ul. Grunwaldzka 25/3", "60-783", "Poznań"));

    }

    public ArrayList<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(ArrayList<Patient> patientsList) {
        this.patientsList = patientsList;
    }
}
