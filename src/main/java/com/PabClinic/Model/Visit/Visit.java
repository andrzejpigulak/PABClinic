package com.PabClinic.Model.Visit;

import com.PabClinic.Model.Doctor.Doctor;
import com.PabClinic.Model.Patient.Patient;

import java.util.ArrayList;
import java.util.Objects;

public class Visit {

    private String dateVisit;
    private String timeVisit;
    private Doctor doctor;
    private Patient patient;
    private ArrayList<String> timeList = new ArrayList<>();

    public Visit() {
    }

    public Visit(String timeVisit) {
        this.timeVisit = timeVisit;
    }

    public Visit(String dateVisit, String timeVisit, Doctor doctor, Patient patient) {
        this.dateVisit = dateVisit;
        this.timeVisit = timeVisit;
        this.doctor = doctor;
        this.patient = patient;
    }


    public String getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(String dateVisit) {
        this.dateVisit = dateVisit;
    }

    public String getTimeVisit() {
        return timeVisit;
    }

    public void setTimeVisit(String timeVisit) {
        this.timeVisit = timeVisit;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(dateVisit, visit.dateVisit) && Objects.equals(timeVisit, visit.timeVisit) && Objects.equals(doctor, visit.doctor) && Objects.equals(patient, visit.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateVisit, timeVisit, doctor, patient);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "dateVisit='" + dateVisit + '\'' +
                ", timeVisit='" + timeVisit + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}
