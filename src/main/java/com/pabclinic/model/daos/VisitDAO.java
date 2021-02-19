package com.pabclinic.model.daos;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDAO {

    private String visitDate;

    private String visitTime;

    private String doctorName;

    private String doctorLastName;

    private String patientName;

    private String patientLastName;

    public VisitDAO(String visitDate) {
        this.visitDate = visitDate;
    }
}
