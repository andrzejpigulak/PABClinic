package com.pabclinic.model.dtos;

import org.springframework.stereotype.Component;

@Component
public class SingleVisitDTO {

    private String visitDate;
    private String visitTime;
    private String doctorName;
    private String doctorLastName;
    private String patientName;
    private String patientLastName;

    public SingleVisitDTO(String visitDate, String visitTime, String doctorName, String doctorLastName, String patientName, String patientLastName) {
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.doctorName = doctorName;
        this.doctorLastName = doctorLastName;
        this.patientName = patientName;
        this.patientLastName = patientLastName;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }
}
