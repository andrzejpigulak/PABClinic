package com.PabClinic.model.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private String visitDate;

    private String visitTime;

    private String doctorName;

    private String doctorLastName;

    private String patientName;

    private String patientLastName;

    private String visitDescription;

    public VisitDTO(String visitDate, String doctorName, String doctorLastName, String patientName, String patientLastName, String visitDescription) {
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.doctorLastName = doctorLastName;
        this.patientName = patientName;
        this.patientLastName = patientLastName;
        this.visitDescription = visitDescription;
    }
}
