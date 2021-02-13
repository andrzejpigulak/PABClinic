package com.PabClinic.Model.Visit;

import com.PabClinic.Model.Doctor.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VisitHistory {

    private String data;
    private String doctorName;
    private String doctorLastName;
    private String patientName;
    private String patientLastName;
    private String visitDescription;

}
