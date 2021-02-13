package com.PabClinic.Model.Visit;

import com.PabClinic.Model.Doctor.DoctorFabrik;
import com.PabClinic.Model.Patient.PatientFabrik;
import lombok.Data;

import java.util.ArrayList;
import java.util.Objects;

@Data
public class VisitFabrik {

    ArrayList<Visit> visitsList = new ArrayList<>();
    ArrayList<Visit> visitTime = new ArrayList<>();

    DataBase dataBase = new DataBase();
    private ArrayList<Doctor> doctorList = new ArrayList<>();

    PatientFabrik patientFabrik = new PatientFabrik();

    public VisitFabrik() {

        dataBase.getDoctors(doctorList);

        visitTime.add(new Visit("8:00"));
        visitTime.add(new Visit("8:30"));
        visitTime.add(new Visit("9:00"));
        visitTime.add(new Visit("9:30"));
        visitTime.add(new Visit("10:00"));

        visitsList.add(new Visit("8:00", "2021-02-15", doctorList.get(2), patientFabrik.getPatientsList().get(0)));
        visitsList.add(new Visit("8:30", "2021-02-15", doctorList.get(2), patientFabrik.getPatientsList().get(1)));
        visitsList.add(new Visit("9:00", "2021-02-15", doctorList.get(2), patientFabrik.getPatientsList().get(2)));
        visitsList.add(new Visit("9:30", "2021-02-15", doctorList.get(2), patientFabrik.getPatientsList().get(3)));
        visitsList.add(new Visit("10:00", "2021-02-15", doctorList.get(2), patientFabrik.getPatientsList().get(4)));
        visitsList.add(new Visit("8:00", "2021-02-15", doctorList.get(3), patientFabrik.getPatientsList().get(0)));
        visitsList.add(new Visit("8:30", "2021-02-15", doctorList.get(1), patientFabrik.getPatientsList().get(1)));
        visitsList.add(new Visit("9:00", "2021-02-15", doctorList.get(4), patientFabrik.getPatientsList().get(2)));
        visitsList.add(new Visit("9:30", "2021-02-15", doctorList.get(5), patientFabrik.getPatientsList().get(3)));
        visitsList.add(new Visit("10:00", "2021-02-15", doctorList.get(8), patientFabrik.getPatientsList().get(4)));


    }



    public ArrayList<Visit> usunGodzine(Visit visit) {
        visitTime.remove(visit);

        return visitTime;
    }

    public ArrayList<Visit> addVisitToList(Visit visit){

        visitsList.add(visit);

        return visitsList;
    }

}
