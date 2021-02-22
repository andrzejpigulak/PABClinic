package com.pabclinic.model.dtos;

import org.springframework.stereotype.Component;

@Component
public class SingleVisitDTO {

    private String visitDate;
    private String visitTime;
    private String doctorName;
    private String doctorLastName;
    private String doctorUsername;
    private String patientName;
    private String patientLastName;
    private String patientUsername;

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

    public String getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorUsername(String doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
    }

    @Override
    public String toString() {
        return "SingleVisitDTO{" +
                "visitDate='" + visitDate + '\'' +
                ", visitTime='" + visitTime + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorLastName='" + doctorLastName + '\'' +
                ", doctorUsername='" + doctorUsername + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", patientUsername='" + patientUsername + '\'' +
                '}';
    }
}


