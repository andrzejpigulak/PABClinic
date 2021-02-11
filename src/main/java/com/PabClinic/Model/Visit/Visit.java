package com.PabClinic.Model.Visit;
import com.PabClinic.Model.Doctor.Doctor;
import com.PabClinic.Model.Patient.Patient;
import lombok.*;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Visit {

    @NonNull
    private String timeVisit;

    private String dateVisit;

    private Doctor doctor;

    private Patient patient;

    private ArrayList<String> timeList = new ArrayList<>();


    public Visit(String timeVisit, String dateVisit, Doctor doctor, Patient patient) {
        this.timeVisit = timeVisit;
        this.dateVisit = dateVisit;
        this.doctor = doctor;
        this.patient = patient;
    }
}
