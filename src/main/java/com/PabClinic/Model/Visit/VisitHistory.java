package com.PabClinic.Model.Visit;

import com.PabClinic.Model.Doctor.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VisitHistory {

    private String data;
    private Doctor doctor;
    private String opis;

}
