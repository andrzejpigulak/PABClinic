package com.pabclinic.model.dtos;
import lombok.*;


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

    public VisitDTO(String visitDate, String visitTime, String doctorName, String doctorLastName, String patientName, String patientLastName) {
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.doctorName = doctorName;
        this.doctorLastName = doctorLastName;
        this.patientName = patientName;
        this.patientLastName = patientLastName;
    }
}
