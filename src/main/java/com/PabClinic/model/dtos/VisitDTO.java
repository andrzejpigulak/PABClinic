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

    public VisitDTO(String visitDate) {
        this.visitDate = visitDate;
    }
}
